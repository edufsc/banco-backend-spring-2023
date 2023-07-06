package com.bancospring.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bancospring.backend.model.Gestor;
import com.bancospring.backend.service.GestorService;

import java.util.List;
import java.util.Optional;

@RestController
// ruta base de la API de Gestor
// equivalente a http://localhost:8080/gestor (8080 es el puerto por defecto de Spring, puede modificarse)
@RequestMapping("/gestor")
// permite las peticiones desde el puerto por defecto del front en angular
// recomendable solo para desarrollo
@CrossOrigin(origins = "http://localhost:4200")
public class GestorController {

	// para inyectar el servicio de Gestor
	@Autowired
	private GestorService gestorService;

	// mapeo para las peticiones con HTTP GET
	// si no se indica nada la ruta es la indicada arriba, en el @RequestMapping
	@GetMapping
	public List<Gestor> findAll() {
		return gestorService.findAll();
	}

	// si se indica una ruta entre paréntesis, se concatena a la ruta indicada en el
	// @RequestMapping
	// en este caso http://localhost:8080/gestor/{id}, donde {id} será un número
	// Ej. http://localhost:8080/gestor/12 para el gestor con id 12
	// lo indicado entre llaves {} son variables y se pueden asociar con parámetros
	// con @PathVariable
	@GetMapping("/{id}")
	public Gestor findById(@PathVariable Long id) {
		return gestorService.findById(id);
	}

	// mapeo para las peticiones con HTTP POST
	// POST recibe la información el el body y se asocia con un parámetro usando
	// @RequestBody
	// en este caso espera recibir un objeto de tipo Gestor en el body de la
	// petición
	@PostMapping
	public Gestor save(@RequestBody Gestor gestor) {
		return gestorService.save(gestor);
	}

	// mapeo para las peticiones con HTTP PUT
	// PUT se suele utilizar para actualizar
	// en nuestro caso hará lo mismo que POST, aunque es buena idea tenerlo separado
	// para posibles cambios futuros
	@PutMapping
	public Gestor update(@RequestBody Gestor gestor) {
		return gestorService.save(gestor);
	}

	// mapeo para las peticiones con HTTP DELETE
	// DELETE suele implicar eliminar una entidad de la base de datos
	// en este caso indicamos el Gestor a eliminar pasando su id como variable de
	// ruta (@PathVariable)
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		gestorService.deleteById(id);
	}

	// el login siempre debería hacerse con POST
	// de esta forma las credenciales viajan en el body
	// el body se puede cifrar, la URL no, por eso evitamos GET para este propósito
	@PostMapping("/login")
	// retornar una ResponseEntity en lugar de solo el gestor nos permite gestionar
	// los códigos de respuesta
	public ResponseEntity<Gestor> login(@RequestBody Gestor gestor) {
		Optional<Gestor> optGestor = gestorService.login(gestor.getCorreo(), gestor.getPassword());
		if (optGestor.isPresent()) {
			// responde con 200 OK
			return ResponseEntity.ok(optGestor.get());
		} else {
			// responde con 401 UNAUTHORIZED
			// NOTA: en este caso recibiremos un error 401 en el front si el login no es correcto
			// no recibiremos null, tendremos que tenerlo en cuenta
			return ResponseEntity.status(401).build();
		}
	}
}
