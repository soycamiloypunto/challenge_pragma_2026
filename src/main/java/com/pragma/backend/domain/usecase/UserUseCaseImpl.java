package com.pragma.backend.domain.usecase;

import com.pragma.backend.domain.exception.UserNotFoundException;
import com.pragma.backend.domain.model.User;
import com.pragma.backend.domain.port.in.UserUseCase;
import com.pragma.backend.domain.port.out.UserRepositoryPort;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Implementación del caso de uso. Solo depende de puertos (interfaces del dominio),
 * nunca de detalles de infraestructura: así se puede probar sin Spring ni base de datos.
 */
@Service
public class UserUseCaseImpl implements UserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public UserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User createUser(User user) {
        user.setId(null);
        return userRepositoryPort.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepositoryPort.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositoryPort.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        if (!userRepositoryPort.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        user.setId(id);
        return userRepositoryPort.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepositoryPort.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepositoryPort.deleteById(id);
    }
}
