package io.reflectoring.demo.Controller;

import io.reflectoring.demo.Dtos.UserDto;
import io.reflectoring.demo.Service.IUserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController  {
    private final IUserService userService;

    @PostMapping(value="/register")
    public boolean registerUser(@Valid @NotNull @RequestParam("user_name") String userName,@Valid @NotNull @RequestParam("email") String email,@Valid @NotNull @RequestParam("password") String password){
        final UserDto userDto=new UserDto().setPassword(password).setName(userName).setEmailId(email);
        return userService.registerUser(userDto);
    }
    @PostMapping(value="/login")
    public String loginUser(@Valid @NotNull @RequestParam("email") String email,@Valid @NotNull @RequestParam("password") String password){
        final UserDto userDto=new UserDto().setPassword(password).setEmailId(email);
        return userService.loginUser(userDto);
    }
}
