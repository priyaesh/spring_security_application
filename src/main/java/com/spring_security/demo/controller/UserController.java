package com.spring_security.demo.controller;

import com.spring_security.demo.entity.User;
import com.spring_security.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class UserController {

    private  final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/register")
    public User register(@RequestBody User user){
    return userRepository.save(user);

    }
    @PostMapping("/login")
    public String login(@RequestBody User user){
        var U =userRepository.findByUserName(user.getUserName());
        if(!Objects.isNull(U))
            return "success";
        return "failure";
    }
}
