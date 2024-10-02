package io.reflectoring.demo.Repositories;

import io.reflectoring.demo.Entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<TaskEntity,Integer> {
}
