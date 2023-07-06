package com.bancospring.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancospring.backend.model.Gestor;

public interface GestorRepository extends JpaRepository<Gestor, Long> {
	
	// JPA nos permite construir "queries" de MySQL a través del nombre del método
	// en este caso indicamos que buscaremos un gestor que tenga el correo y la contraseña recibidos
	// recomendable buscar más información sobre las palabras clave para hacer consultas con JPA
	Optional<Gestor> findByCorreoAndPassword(String correo, String password);
}
