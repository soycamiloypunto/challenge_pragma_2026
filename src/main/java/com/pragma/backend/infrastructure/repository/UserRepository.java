package com.pragma.backend.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pragma.backend.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}