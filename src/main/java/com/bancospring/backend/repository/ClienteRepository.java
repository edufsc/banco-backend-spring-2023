package com.bancospring.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancospring.backend.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
