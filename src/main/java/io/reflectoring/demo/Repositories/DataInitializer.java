package io.reflectoring.demo.Repositories;

import io.reflectoring.demo.Entity.TaskEntity;
import io.reflectoring.demo.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {
    private final UserRepo userRepo;

    // Constructor Injection for UserRepo
    @Autowired
    public DataInitializer(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        initializeData();
    }

    // Method to initialize and save data
    private void initializeData() {
        // Create TaskEntity objects
        TaskEntity task1 = new TaskEntity();
        task1.setTitle("Task 1");
        task1.setDescription("Description for Task 1");
        task1.setDueDate(LocalDate.now());

        TaskEntity task2 = new TaskEntity();
        task2.setTitle("Task 2");
        task2.setDescription("Description for Task 2");
        task2.setDueDate(LocalDate.now());

        // Create a Set of tasks
        Set<TaskEntity> tasks = new HashSet<>();
        tasks.add(task1);
        tasks.add(task2);

        // Create a UserEntity
        UserEntity user = new UserEntity();
        user.setName("user");
        user.setEmailId("email.com");
        user.setPassword("12312414");
        user.setTasks(tasks);

        // Set the user for each task (This is important)
//        task1.setUser(user);
//        task2.setUser(user);

        // Save UserEntity, which will also save TaskEntity due to CascadeType.ALL
        userRepo.save(user);

        System.out.println("Data has been initialized.");
    }
}

