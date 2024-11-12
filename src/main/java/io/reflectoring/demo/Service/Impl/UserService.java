package io.reflectoring.demo.Service.Impl;

import io.reflectoring.demo.Dtos.UserDto;
import io.reflectoring.demo.Entity.UserEntity;
import io.reflectoring.demo.Mappers.UserMapper;
import io.reflectoring.demo.Repositories.UserRepo;
import io.reflectoring.demo.Service.IUserService;
import io.reflectoring.demo.Service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;


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

    /**
     * @param userDto
     * @return
     */
    @Override
    public boolean registerUser(UserDto userDto) {
        final UserEntity userEntity=userMapper.toUserEntity(userDto);
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        try {
            userRepo.save(userEntity);
            return true;
        }catch (DataIntegrityViolationException e){
            throw new RuntimeException("Unable to save in database due to database integration error:"+e.getMessage());
        }
    }

    /**
     * @param userDto
     */
    @Override
    public String loginUser(final UserDto userDto) {
//        final String encryptedPassword=passwordEncoder.encode(userDto.getPassword());
//        final Optional<UserEntity> userEntity=userRepo.findByNameAndPassword(userDto.getName(),encryptedPassword);
//        if(userEntity.isEmpty())throw new RuntimeException("Your password or username does not exist");
//        return true;
        final Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getName(),userDto.getPassword()));
        if(authentication.isAuthenticated())return jwtService.getToken(userDto.getName());
        throw new RuntimeException("Username or password is not correct");
    }


}
