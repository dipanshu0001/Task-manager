package io.reflectoring.demo.Controller;

import io.reflectoring.demo.Dtos.TaskDto;
import io.reflectoring.demo.Entity.TaskEntity;
import io.reflectoring.demo.Mappers.TaskMapper;
import io.reflectoring.demo.Repositories.TaskRepo;
import io.reflectoring.demo.Repositories.UserRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@RequestMapping("/taskapi")
public class TaskController {
    private UserRepo userRepo;
    private TaskRepo taskRepo;

    private TaskMapper taskMapper;

    @Autowired
    public TaskController(UserRepo userRepo, TaskRepo taskRepo,TaskMapper taskMapper) {
        this.userRepo = userRepo;
        this.taskRepo = taskRepo;
        this.taskMapper=taskMapper;
    }

    //Create task
    @PostMapping("/create-task")
    public boolean createTask(@Valid @RequestBody TaskDto taskDto) {
        taskDto.setTitle("Dipanshu");
        TaskEntity task=taskMapper.toTaskEntity(taskDto);
        System.out.print(task.getTitle());
        return false;
    }


}
