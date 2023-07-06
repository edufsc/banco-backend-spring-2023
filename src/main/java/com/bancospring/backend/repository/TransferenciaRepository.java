package com.bancospring.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancospring.backend.model.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

	// utilizando JPA podemos buscar las transferencias enviadas por un Cliente a
	// partir de su id
	// este método se traducirá con hibernate en una consulta SQL a nuestra base de
	// datos
	List<Transferencia> findByOrdenanteId(Long id);
}
