package br.com.ciclistas.sjc.model;

import java.util.Date;
import java.util.List;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * @author Pedro Hos
 *
 */
@Entity
public class Occurrence extends PanacheEntity {

	@Column(updatable = false, nullable = false)
	public String name; // TODO: use keycloak in the Future

	@JsonbDateFormat("dd-MM-yyy hh:mm:ss")
	@Column(nullable = false, updatable = false)
	public Date occurrenceDate = new Date();

	@Column(updatable = false, nullable = false)
	public Double latitude;

	@Column(updatable = false, nullable = false)
	public Double longitude;

	public String location;

	@CollectionTable(joinColumns = @JoinColumn(name = "id"))
	@ElementCollection(fetch = FetchType.EAGER)
	public List<String> pathPhoto;

	@ManyToOne(cascade = CascadeType.ALL)
	public Status status;

	@ManyToOne(optional = true)
	@JoinColumn(nullable = true)
	public OccurrenceType type;

	@Column(length = 1000)
	public String description;
	
	public Long getId() {
		return this.id;
	}

}
