package br.com.ciclistas.sjc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Pedro Hos
 *
 */
@Entity
@Table(name = "OCCURRENCE_TYPE")
public class OccurrenceType extends DefaultEntity {

	private static final long serialVersionUID = 4338524425858692845L;
	
	@Column(nullable = false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
