package io.reflectoring.demo.Service;

import io.reflectoring.demo.Dtos.TaskDto;

import java.util.List;

public interface ITaskService {
    List<TaskDto> getTaskListForSpeceficUser(final Integer userId);
    boolean deleteTask(final Integer taskId);

    boolean updateTask(final TaskDto taskDto);
}
