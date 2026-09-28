package com.pragma.backend.infrastructure.entrypoint.rest.mapper;

import com.pragma.backend.domain.model.User;
import com.pragma.backend.infrastructure.entrypoint.rest.dto.UserRequestDto;
import com.pragma.backend.infrastructure.entrypoint.rest.dto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRestMapper {

    @Mapping(target = "id", ignore = true)
    User toDomain(UserRequestDto dto);

    UserResponseDto toResponse(User user);
}
