package com.bancospring.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancospring.backend.model.Gestor;
import com.bancospring.backend.repository.GestorRepository;

@Service
public class GestorService {

	@Autowired
	private GestorRepository gestorRepository;

	public List<Gestor> findAll() {
		return gestorRepository.findAll();
	}

	public Gestor findById(Long id) {
		return gestorRepository.findById(id).orElse(null);
	}

	public Gestor save(Gestor gestor) {
		return gestorRepository.save(gestor);
	}

	public void deleteById(Long id) {
		gestorRepository.deleteById(id);
	}

	// una forma simple para hacer pruebas de login es buscar el gestor por correo
	// y contraseña
	// esto solo es posible si no ciframos la contraseña
	// por tanto no es viable para una aplicación real
	// buscar info de Spring Security para securizar correctamente
	public Optional<Gestor> login(String correo, String password) {
		return gestorRepository.findByCorreoAndPassword(correo, password);
	}
}
