package com.andrewn.java2304springmvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {
    @Bean
    CommandLineRunner loadDatabase(UserRepository userRepository) {
        return (args) -> {
            userRepository.save(new User("asd", "123", "a@mail.ru", 23));
            userRepository.save(new User("qwe", "456", "b@mail.com", 25));
        };
    }
}
