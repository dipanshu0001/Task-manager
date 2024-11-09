package io.reflectoring.demo.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;

@Entity
@Data
@Table(name="user_details")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int userId;

    @Column(name="user_name")
    @NonNull
    String name;

    @NonNull
    String password;

    @Column(name="email_id")
    @NonNull
    String emailId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
    Set<TaskEntity> tasks;

}
