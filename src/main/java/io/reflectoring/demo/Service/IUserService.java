package io.reflectoring.demo.Service;

import io.reflectoring.demo.Dtos.UserDto;

import java.util.Optional;

public interface IUserService {
    Optional<UserDto> getByUserName(String username);
    boolean registerUser(final UserDto userDto);

    String loginUser(final UserDto userDto);
}
