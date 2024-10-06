package io.reflectoring.demo;

import io.reflectoring.demo.Entity.TaskEntity;
import io.reflectoring.demo.Entity.UserEntity;
import io.reflectoring.demo.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.SpringSessionContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@ComponentScan("io.reflectoring.demo")
public class TaskManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);

	}
}
