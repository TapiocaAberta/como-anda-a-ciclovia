package br.com.ciclistas.sjc.resources;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ciclistas.sjc.model.Occurrence;
import br.com.ciclistas.sjc.repository.OccurrenceRepository;
import br.com.ciclistas.sjc.repository.OccurrenceTypeRepository;
import br.com.ciclistas.sjc.resources.utils.JaxrsUtils;


/**
 * @author Pedro Hos
 */

@Path("occurrences")
@Consumes("application/json; charset=UTF-8")
@Produces("application/json; charset=UTF-8")
public class OccurrenceResource {
	
	private Logger logger =  Logger.getLogger(OccurrenceResource.class.getName());

	@ConfigProperty(name = "path.image.dir")
	private String localPath;

	@ConfigProperty(name ="web.context")
	private String webContext;
	
	@Inject
	private OccurrenceRepository occurrenceRepository;
	
	@Inject
	private OccurrenceTypeRepository occurrenceTypeRepository;
	
	@POST
	public Response newOccurrence(final Occurrence occurrence) {
		occurrenceRepository.persist(occurrence);
		return Response.created(URI.create("/occurrences/" + occurrence.getId())).build();
	}
	
	@POST
	@Consumes("multipart/form-data;charset=UTF-8")
	@Path(value = "/upload")
	@Transactional
	public Response newOccurrenceWithUploads(MultipartFormDataInput multipart) throws IOException {
		
		logger.info("Saving new occurrence!");

		Occurrence occurrence = getOccurence(multipart);
		Optional<List<InputPart>> photos = Optional.ofNullable(multipart.getFormDataMap().get("uploads"));

		photos.ifPresent(f -> occurrence.setPathPhoto(savePhoto(f)));
		
		occurrenceRepository.persist(occurrence);
		return Response.created(URI.create("/occurrences/" + occurrence.getId())).entity(occurrence).build();
	}

	@Transactional
	private Occurrence getOccurence(MultipartFormDataInput multipart) throws IOException {
		
		Occurrence occurrence = new ObjectMapper().readValue(multipart.getFormDataPart("occurrence", String.class, null), Occurrence.class);
		
		//Ok, this is not funny!
		if(occurrence.getType() == null) {
			occurrence.setType(occurrenceTypeRepository.findById(99L));
		}
		
		return occurrence;
	}

	private List<String> savePhoto(List<InputPart> photos) {
		
		List<String> paths = new ArrayList<>();
		
		for (InputPart photo : photos) {
			
			String fileName = UUID.randomUUID() + ".jpeg";
			
			try {
				
				InputStream is = photo.getBody(InputStream.class, null);
				
				String pathAndFileName = localPath + "/" + fileName;
				Files.write(Paths.get(pathAndFileName), IOUtils.toByteArray(is));
				
				paths.add(webContext + "/images/" + fileName);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return paths;
	}
	
	@GET
	public Response allOccurrence() {
		return Response.ok().entity(JaxrsUtils.throw404IfNull(occurrenceRepository.listAll())).build();
	}
	
	@GET
	@Path(value = "/{id}")
	public Response findById(@PathParam("id") final Long id) {
		return Response.ok().entity(JaxrsUtils.throw404IfNull(occurrenceRepository.findById(id))).build();
	}

}