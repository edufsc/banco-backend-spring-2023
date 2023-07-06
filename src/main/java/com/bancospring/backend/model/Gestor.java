package com.bancospring.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Gestor {

	// indica que será la clave primaria
	@Id
	// indica que debe generar la clave primaria al guardar
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// En lugar de Long se puede usar Integer, pero Long admite valores enteros más altos
	// por tanto es más adecuado para ids en aplicaciones reales
	private Long id;

	// indica que el campo es obligatorio
	// si no está al guardar obtendremos un error
	@Column(nullable = false)
	private String usuario;

	@Column(nullable = false)
	private String correo;

	@Column(nullable = false)
	private String password;

	// Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
