package com.pragma.backend.infrastructure.entrypoint.rest;

import com.pragma.backend.domain.port.in.UserUseCase;
import com.pragma.backend.infrastructure.entrypoint.rest.dto.UserRequestDto;
import com.pragma.backend.infrastructure.entrypoint.rest.dto.UserResponseDto;
import com.pragma.backend.infrastructure.entrypoint.rest.mapper.UserRestMapper;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Adaptador de entrada REST. Solo traduce HTTP <-> dominio; no contiene lógica de negocio.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserUseCase userUseCase;
    private final UserRestMapper userRestMapper;

    public UserController(UserUseCase userUseCase, UserRestMapper userRestMapper) {
        this.userUseCase = userUseCase;
        this.userRestMapper = userRestMapper;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@Valid @RequestBody UserRequestDto request) {
        var created = userUseCase.createUser(userRestMapper.toDomain(request));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(userRestMapper.toResponse(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userRestMapper.toResponse(userUseCase.getUserById(id)));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll() {
        var response = userUseCase.getAllUsers().stream()
                .map(userRestMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Long id,
                                                   @Valid @RequestBody UserRequestDto request) {
        var updated = userUseCase.updateUser(id, userRestMapper.toDomain(request));
        return ResponseEntity.ok(userRestMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userUseCase.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
