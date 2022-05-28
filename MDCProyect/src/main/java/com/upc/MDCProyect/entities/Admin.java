package com.example.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin implements Serializable {

	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre_Admin", nullable=false, length=50)
	private String nombreAdmin;
	
	@Column(name = "apellido_Admin", nullable=false, length=50)
	private String apellidoAdmin;
	
	@Column(name = "correo_Admin", nullable=false, length=100)
	private String correoAdmin;
	
	@Column(name = "dni_Admin", nullable=false, length=8)
	private String dniAdmin;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreAdmin() {
		return nombreAdmin;
	}

	public void setNombreAdmin(String nombreAdmin) {
		this.nombreAdmin = nombreAdmin;
	}

	public String getApellidoAdmin() {
		return apellidoAdmin;
	}

	public void setApellidoAdmin(String apellidoAdmin) {
		this.apellidoAdmin = apellidoAdmin;
	}

	public String getCorreoAdmin() {
		return correoAdmin;
	}

	public void setCorreoAdmin(String correoAdmin) {
		this.correoAdmin = correoAdmin;
	}

	public String getDniAdmin() {
		return dniAdmin;
	}

	public void setDniAdmin(String dniAdmin) {
		this.dniAdmin = dniAdmin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
