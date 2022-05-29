package com.andrewn.java2304springmvc.config;

import com.andrewn.java2304springmvc.model.User;
import com.andrewn.java2304springmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {
    @Bean
    CommandLineRunner loadDatabase(UserRepository userRepository, @Value("${spring.datasource.url}") String databaseUrl) {
        return (args) -> {
            System.out.println("Adding two users into " + databaseUrl);
            userRepository.save(new User("asd", "123", "a@mail.ru", 23));
            userRepository.save(new User("qwe", "456", "b@mail.com", 25));
            userRepository.save(new User("zxc", "789", "c@mail.com", 25));

        };
    }
}
