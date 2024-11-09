package io.reflectoring.demo.Mappers;

import io.reflectoring.demo.Dtos.UserDto;
import io.reflectoring.demo.Entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface UserMapper {
    UserDto toUserDTO(final UserEntity userEntity);
    UserEntity toUserEntity(final UserDto userDto);
}
