package com.pragma.backend.domain.port.in;

import com.pragma.backend.domain.model.User;
import java.util.List;

/**
 * Puerto de entrada: contrato de casos de uso que la capa de entrada (REST) invoca.
 */
public interface UserUseCase {

    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
