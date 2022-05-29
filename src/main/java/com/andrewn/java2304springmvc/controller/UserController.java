package com.andrewn.java2304springmvc.controller;

import com.andrewn.java2304springmvc.model.User;
import com.andrewn.java2304springmvc.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{age}")
    public List<User> getUsersByAge(@PathVariable("age") int age) {
        return userRepository.findByAge(age);
    }
}
