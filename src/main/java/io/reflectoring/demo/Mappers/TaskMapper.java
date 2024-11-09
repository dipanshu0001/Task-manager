package io.reflectoring.demo.Mappers;

import io.reflectoring.demo.Dtos.TaskDto;
import io.reflectoring.demo.Dtos.UserDto;
import io.reflectoring.demo.Entity.TaskEntity;
import io.reflectoring.demo.Entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy= NullValuePropertyMappingStrategy.IGNORE)
public interface TaskMapper {

    public TaskDto toTaskDto(TaskEntity taskEntity);
    public TaskEntity toTaskEntity(TaskDto taskDto);

    UserDto map(UserEntity userEntity);

    // Add the mapping method for UserDto to UserEntity if needed
    UserEntity map(UserDto userDto);

    void updateTaskFromDto(TaskDto taskDto, @MappingTarget TaskEntity taskEntity);
}
