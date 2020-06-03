package br.com.ciclistas.sjc.resources.utils;

import java.util.Optional;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * 
 * @author pedro-hos
 *
 */
public class JaxrsUtils {
	
	public static <T> T throw404IfNull(final T object) {
		
		Optional<T> optionaObject = Optional.ofNullable(object);

		if (!optionaObject.isPresent()) {
			throw new WebApplicationException(Response.status(Status.NOT_FOUND).build());
		}

		return object;
	}

}
