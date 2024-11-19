package com.spring_security.demo.service;

import com.spring_security.demo.entity.User;
import com.spring_security.demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public User register(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return  userRepository.save(user);

    }


    public String verify(User user) {
        var U =userRepository.findByUserName(user.getUserName());
        if(!Objects.isNull(U))
            return "4u543uo3i2p2p22p2o54p2o4p25p42";
        return "failure";

    }
}
