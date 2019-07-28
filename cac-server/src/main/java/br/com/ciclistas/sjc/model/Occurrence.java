package br.com.ciclistas.sjc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


/**
 * @author Pedro Hos
 *
 */
@Entity
@Table(name = "OCCURRENCE")
public class Occurrence extends PanacheEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
	public Long id;
	
	@Column(name = "name", updatable = false, nullable = false)
	public String name; //TODO: use keycloak in the futere
	
	@Column(nullable = false, updatable = false)
	public Date occurrenceDate = new Date();
	
	@Column(updatable = false, nullable = false)
	public Double latitude;

	@Column(updatable = false, nullable = false)
	public Double longitude;
	
	public String location;
	
	@CollectionTable(name="PATH_PHOTOS")
	@ElementCollection(fetch = FetchType.EAGER)
	public List<String> pathPhoto;
	
	@OneToOne
	public Status status;
	
	@OneToOne
	public OccurrenceType type;
	
	@Column(length = 1000)
	public String description;

}
