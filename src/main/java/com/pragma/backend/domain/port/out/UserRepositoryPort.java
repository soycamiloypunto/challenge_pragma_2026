package com.pragma.backend.domain.port.out;

import com.pragma.backend.domain.model.User;
import java.util.List;
import java.util.Optional;

/**
 * Puerto de salida: contrato que el dominio necesita para persistir usuarios,
 * sin conocer la tecnología de persistencia concreta (JPA, Mongo, etc.).
 */
public interface UserRepositoryPort {

    User save(User user);

    Optional<User> findById(Long id);

    List<User> findAll();

    boolean existsById(Long id);

    void deleteById(Long id);
}
