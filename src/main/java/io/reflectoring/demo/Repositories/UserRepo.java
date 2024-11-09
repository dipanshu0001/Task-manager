package io.reflectoring.demo.Repositories;

import io.reflectoring.demo.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {
    @Query(value = "select * from user_details where name = :name", nativeQuery = true)
    Optional<UserEntity> findByName(final String name);
}
