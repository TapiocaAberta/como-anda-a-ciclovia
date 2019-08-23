package br.com.ciclistas.sjc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SYS_USER")
public class SysUser extends DefaultEntity {

	private static final long serialVersionUID = -1139385161519153384L;

	@Column(length = 40)
	private String name;

	@Column(updatable = false, nullable = false)
	private String password;

	@Column(updatable = false, nullable = false)
	private String role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
