package io.reflectoring.demo.Mappers;

import io.reflectoring.demo.Dtos.TaskDto;
import io.reflectoring.demo.Entity.TaskEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    public TaskDto toTaskDto(TaskEntity taskEntity);
    public TaskEntity toTaskEntity(TaskDto taskDto);
}
