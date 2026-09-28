package com.pragma.backend.infrastructure.adapter.persistence;

import com.pragma.backend.domain.model.User;
import com.pragma.backend.domain.port.out.UserRepositoryPort;
import com.pragma.backend.infrastructure.adapter.persistence.mapper.UserEntityMapper;
import com.pragma.backend.infrastructure.adapter.persistence.repository.SpringDataUserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

/**
 * Adaptador de salida: traduce el puerto {@link UserRepositoryPort} a Spring Data JPA.
 */
@Component
public class UserPersistenceAdapter implements UserRepositoryPort {

    private final SpringDataUserRepository springDataUserRepository;
    private final UserEntityMapper userEntityMapper;

    public UserPersistenceAdapter(SpringDataUserRepository springDataUserRepository,
                                   UserEntityMapper userEntityMapper) {
        this.springDataUserRepository = springDataUserRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User save(User user) {
        var entity = userEntityMapper.toEntity(user);
        var saved = springDataUserRepository.save(entity);
        return userEntityMapper.toDomain(saved);
    }

    @Override
    public Optional<User> findById(Long id) {
        return springDataUserRepository.findById(id).map(userEntityMapper::toDomain);
    }

    @Override
    public List<User> findAll() {
        return springDataUserRepository.findAll().stream()
                .map(userEntityMapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsById(Long id) {
        return springDataUserRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        springDataUserRepository.deleteById(id);
    }
}
