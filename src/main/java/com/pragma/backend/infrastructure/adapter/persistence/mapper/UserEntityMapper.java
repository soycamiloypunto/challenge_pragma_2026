package com.pragma.backend.infrastructure.adapter.persistence.mapper;

import com.pragma.backend.domain.model.User;
import com.pragma.backend.infrastructure.adapter.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    UserEntity toEntity(User user);

    User toDomain(UserEntity entity);
}
