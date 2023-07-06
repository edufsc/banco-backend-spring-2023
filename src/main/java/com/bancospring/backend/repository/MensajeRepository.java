package com.bancospring.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancospring.backend.model.Mensaje;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
}
