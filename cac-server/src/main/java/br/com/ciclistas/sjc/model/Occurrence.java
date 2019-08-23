package br.com.ciclistas.sjc.model;

import java.util.Date;
import java.util.List;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * @author Pedro Hos
 *
 */
@Entity
@Table(name = "OCCURRENCE")
public class Occurrence extends DefaultEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2004416450960596166L;

	@Column(name = "name", updatable = false, nullable = false)
	private String name; // TODO: use keycloak in the Future

	@JsonbDateFormat("dd-MM-yyy hh:mm:ss")
	@Column(nullable = false, updatable = false)
	private Date occurrenceDate = new Date();

	@Column(updatable = false, nullable = false)
	private Double latitude;

	@Column(updatable = false, nullable = false)
	private Double longitude;

	private String location;

	@Cascade(CascadeType.ALL)
	@CollectionTable(name = "PATH_PHOTOS")
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> pathPhoto;

	@OneToOne
	private Status status;

	@OneToOne(optional = true)
	@JoinColumn(nullable = true)
	private OccurrenceType type;

	@Column(length = 1000)
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOccurrenceDate() {
		return occurrenceDate;
	}

	public void setOccurrenceDate(Date occurrenceDate) {
		this.occurrenceDate = occurrenceDate;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<String> getPathPhoto() {
		return pathPhoto;
	}

	public void setPathPhoto(List<String> pathPhoto) {
		this.pathPhoto = pathPhoto;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public OccurrenceType getType() {
		return type;
	}

	public void setType(OccurrenceType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
