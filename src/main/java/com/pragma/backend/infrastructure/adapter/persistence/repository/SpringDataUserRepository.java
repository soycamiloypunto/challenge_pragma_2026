package com.pragma.backend.infrastructure.adapter.persistence.repository;

import com.pragma.backend.infrastructure.adapter.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio técnico de Spring Data. No es el puerto de salida del dominio:
 * es un detalle de implementación que solo el adaptador de persistencia conoce.
 */
public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long> {
}
