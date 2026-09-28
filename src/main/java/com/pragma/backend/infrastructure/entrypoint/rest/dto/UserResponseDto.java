package com.pragma.backend.infrastructure.entrypoint.rest.dto;

public record UserResponseDto(
        Long id,
        String name,
        String email
) {
}
