package io.reflectoring.demo.Service.Impl;

import io.reflectoring.demo.Dtos.TaskDto;
import io.reflectoring.demo.Entity.TaskEntity;
import io.reflectoring.demo.Mappers.TaskMapper;
import io.reflectoring.demo.Repositories.TaskRepo;
import io.reflectoring.demo.Service.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements ITaskService {
    private final TaskRepo taskRepo;
    private final TaskMapper taskMapper;

    @Override
    public List<TaskDto> getTaskListForSpeceficUser(Integer userId) {
        return taskRepo.findByUser(userId).stream().map(taskMapper::toTaskDto).collect(Collectors.toList());
    }

    @Override
    public boolean deleteTask(Integer taskId) {
        taskRepo.deleteById(taskId);
        return true;
    }

    /**
     * @param taskDto
     * @return
     */
    @Override
    public boolean updateTask(final TaskDto taskDto) {
        final TaskEntity taskEntity =taskRepo.findById(taskDto.getId()).orElseThrow(()->new RuntimeException("Given Task is not present in System"));
        taskMapper.updateTaskFromDto(taskDto,taskEntity);
        taskRepo.save(taskEntity);
        return true;
    }
}
