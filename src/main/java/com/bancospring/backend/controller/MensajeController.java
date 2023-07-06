package com.bancospring.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bancospring.backend.model.Mensaje;
import com.bancospring.backend.service.MensajeService;

import java.util.List;

@RestController
@RequestMapping("/mensaje")
@CrossOrigin(origins = "http://localhost:4200")
public class MensajeController {

	@Autowired
	private MensajeService mensajeService;

	@GetMapping
	public List<Mensaje> findAll() {
		return mensajeService.findAll();
	}

	@GetMapping("/{id}")
	public Mensaje findById(@PathVariable Long id) {
		return mensajeService.findById(id);
	}

	@PostMapping
	public Mensaje save(@RequestBody Mensaje mensaje) {
		return mensajeService.save(mensaje);
	}

	@PutMapping
	public Mensaje update(@RequestBody Mensaje mensaje) {
		return mensajeService.save(mensaje);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		mensajeService.deleteById(id);
	}
}
