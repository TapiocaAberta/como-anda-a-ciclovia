package br.com.ciclistas.sjc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Pedro Hos
 *
 */
@Entity
@Table(name = "STATUS")
public class Status {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
	public Long id;
		
	@Column(nullable = false)
	public String name;
	
	@Column(nullable = false)
	public String description;
	
	@Column(name = "pin_name", nullable = false)
	public String pinName;
	
}
