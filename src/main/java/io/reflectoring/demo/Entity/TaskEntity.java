package io.reflectoring.demo.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Table(name="task")
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("task_id")
    int id;

//    @NonNull
    @JsonProperty("task_title")
    String title;

//    @NonNull
    @JsonProperty("task_description")
    String Description;

//    @NonNull
    @JsonProperty("task_due_date")
    LocalDate dueDate=LocalDate.now();

    @ManyToOne
    @JoinColumn(name="userId")
    private UserEntity user;
}

