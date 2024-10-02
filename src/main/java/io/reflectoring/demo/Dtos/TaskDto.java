package io.reflectoring.demo.Dtos;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class TaskDto {
    private String title;
    private String Description;

    @NotNull(message="Due date cant be null")
    @FutureOrPresent(message="Due date should be in present or in future")
    private LocalDate dueDate;
    private UserDto user;
}
