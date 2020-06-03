package br.com.ciclistas.sjc.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * @author Pedro Hos
 *
 */
@Entity
public class OccurrenceType extends PanacheEntity {
	
	@Column(nullable = false)
	public String name;

	public Long getId() {
		return this.id;
	}
	
}
