package io.reflectoring.demo.Controller;

import io.reflectoring.demo.Dtos.TaskDto;
import io.reflectoring.demo.Entity.TaskEntity;
import io.reflectoring.demo.Mappers.TaskMapper;
import io.reflectoring.demo.Repositories.TaskRepo;
import io.reflectoring.demo.Repositories.UserRepo;
import io.reflectoring.demo.Service.ITaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskapi")
public class TaskController {
    private UserRepo userRepo;
    private TaskRepo taskRepo;

    private TaskMapper taskMapper;

    private final ITaskService taskService;

    @Autowired
    public TaskController(UserRepo userRepo, TaskRepo taskRepo, TaskMapper taskMapper, ITaskService taskService) {
        this.userRepo = userRepo;
        this.taskRepo = taskRepo;
        this.taskMapper=taskMapper;
        this.taskService = taskService;
    }

    //Create task
    @PostMapping("/create-task")
    public boolean createTask(@Valid @RequestBody TaskDto taskDto) {
        taskDto.setTitle("Dipanshu");
        TaskEntity task=taskMapper.toTaskEntity(taskDto);
        System.out.print(task.getTitle());
        return false;
    } @GetMapping("/get-task")
    public List<TaskDto> getTask(@Valid @RequestParam("user_id") Integer userId) {
        return taskService.getTaskListForSpeceficUser(userId);
    }
    @PostMapping("/delete-task")
    public boolean deleteTask(@Valid @RequestParam("task_id") Integer id) {
        return taskService.deleteTask(id);
    }
    @PostMapping("/update-task")
    public boolean updateTask(@Valid @RequestBody TaskDto taskDto) {
        return taskService.updateTask(taskDto);
    }


}
