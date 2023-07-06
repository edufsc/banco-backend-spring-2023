package com.bancospring.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String usuario;

	@Column(nullable = false)
	private String correo;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private Double saldo;

	// indica que hay una relación de "muchos" clientes con "un" gestor 
	@ManyToOne
	// la propiedad name indica cómo se llamará la columna de la relación
	// si no se indica JPA le asigna el nombre atributo_columna (en este caso sería igualmente gestor_id)
	@JoinColumn(name = "gestor_id", nullable = false)
	private Gestor gestor;

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

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Gestor getGestor() {
		return gestor;
	}

	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}

}
