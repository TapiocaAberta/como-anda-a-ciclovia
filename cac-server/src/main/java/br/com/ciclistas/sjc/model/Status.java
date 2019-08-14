package br.com.ciclistas.sjc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * @author Pedro Hos
 *
 */
@Entity
@Table(name = "STATUS")
public class Status extends PanacheEntity {

	@Column(nullable = false)
	public String name;

	@Column(nullable = false)
	public String description;

	@Column(name = "pin_name", nullable = false)
	public String pinName;

	public Long getId() {
		return this.id;
	}

}
