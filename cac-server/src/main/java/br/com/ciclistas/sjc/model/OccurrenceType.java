package br.com.ciclistas.sjc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * @author Pedro Hos
 *
 */
@Entity
@Table(name = "OCCURRENCE_TYPE")
public class OccurrenceType extends PanacheEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
	public Long id;
		
	@Column(nullable = false)
	public String name;


}
