package com.andrewn.java2304springmvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @GetMapping("/")
//    public String index() {
//        return "{\"message\": \"hello\"}";
//    }
//
//    @GetMapping("/asd")
//    public String returnAsd() {
//        return "{\"message\": \"asd\"}";
//    }

    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
