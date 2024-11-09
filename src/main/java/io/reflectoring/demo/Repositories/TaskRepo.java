package io.reflectoring.demo.Repositories;

import io.reflectoring.demo.Entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<TaskEntity,Integer> {
    @Query(value="Select * from task where user_id=:userId",nativeQuery = true)
    List<TaskEntity> findByUser(@Param("userId") Integer userId);
}
