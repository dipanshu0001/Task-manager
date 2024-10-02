package io.reflectoring.demo.Dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDto {
    private String name;
    @Email(message="Email can't be empty")
    private String emailId;
    @NotBlank(message="Password cant be blank")
    @Size(min=8,max=16,message = "Password length should be between 8 to 16 character")
    private String password;
    private List<TaskDto> taskDtoList;
}
