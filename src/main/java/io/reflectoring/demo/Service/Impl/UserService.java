package io.reflectoring.demo.Service.Impl;

import io.reflectoring.demo.Dtos.UserDto;
import io.reflectoring.demo.Mappers.UserMapper;
import io.reflectoring.demo.Repositories.UserRepo;
import io.reflectoring.demo.Service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;

    /**
     * @param username
     * @return
     */
    @Override
    public Optional<UserDto> getByUserName(String username) {
        return userRepo.findByName(username)
                .map(userMapper::toUserDTO)
                .or(Optional::empty);
    }
}
