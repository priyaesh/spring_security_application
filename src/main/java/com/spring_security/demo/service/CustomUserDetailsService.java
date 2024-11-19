package com.spring_security.demo.service;

import com.spring_security.demo.entity.User;
import com.spring_security.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepository.findByUserName(username);
        if(Objects.isNull(user)){
            System.out.println("User not available");
            throw  new UsernameNotFoundException("user not found");
        }
        return  new CustomUserDetails(user);

    }
}
