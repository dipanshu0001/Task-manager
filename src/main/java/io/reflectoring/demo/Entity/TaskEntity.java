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
    @Column(name="task_id")
    int id;

//    @NonNull
    @Column(name="task_title")
    String title;

//    @NonNull
    @Column(name="task_description")
    String Description;

//    @NonNull
    @Column(name="task_due_date")
    LocalDate dueDate=LocalDate.now();

    @ManyToOne
    @JoinColumn(name="userId")
    private UserEntity user;
}

