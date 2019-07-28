package br.com.ciclistas.sjc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "SYS_USER")
public class SysUser extends PanacheEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
	public Long id;

	@Column(length = 40)
	public String name;
	
	@Column(updatable = false, nullable = false)
	public String password;

	@Column(updatable = false, nullable = false)
	public String role;

}
