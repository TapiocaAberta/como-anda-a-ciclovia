package br.com.ciclistas.sjc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Pedro Hos
 *
 */
@Entity
@Table(name = "STATUS")
public class Status extends DefaultEntity {

	private static final long serialVersionUID = -7789286120713279497L;

	@Column(nullable = false)
	public String name;

	@Column(nullable = false)
	public String description;

	@Column(name = "pin_name", nullable = false)
	public String pinName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPinName() {
		return pinName;
	}

	public void setPinName(String pinName) {
		this.pinName = pinName;
	}

}
