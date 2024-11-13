package io.reflectoring.demo.Service.Impl;

import io.reflectoring.demo.Dtos.UserDto;
import io.reflectoring.demo.Entity.UserEntity;
import io.reflectoring.demo.Entity.UserPrinciple;
import io.reflectoring.demo.Repositories.UserRepo;
import io.reflectoring.demo.Service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomeUserDetailService implements UserDetailsService {

    private final UserRepo userRepo;
    /**
     * @param username the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        Optional<UserEntity> userDtoOptional=userRepo.findByName(username);
        if(userDtoOptional.isEmpty())throw new UsernameNotFoundException("User name Not found");
        return new UserPrinciple(userDtoOptional.get());
    }
}
