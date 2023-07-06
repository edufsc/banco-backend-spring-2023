package com.bancospring.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bancospring.backend.model.Cliente;
import com.bancospring.backend.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> findAll() {
		return clienteService.findAll();
	}

	@GetMapping("/{id}")
	public Cliente findById(@PathVariable Long id) {
		return clienteService.findById(id);
	}

	@PostMapping
	public Cliente save(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}

	@PutMapping
	public Cliente update(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		clienteService.deleteById(id);
	}
}
