package com.andrewn.java2304springmvc.config;

import com.andrewn.java2304springmvc.model.Employee;
import com.andrewn.java2304springmvc.model.User;
import com.andrewn.java2304springmvc.repository.EmployeeRepository;
import com.andrewn.java2304springmvc.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {
    private static final Logger log = LoggerFactory.getLogger(DatabaseConfig.class);

    @Bean
    CommandLineRunner loadDatabase(UserRepository userRepository,
                                   EmployeeRepository employeeRepository,
                                   @Value("${spring.datasource.url}") String databaseUrl) {
        return (args) -> {
            System.out.println("Adding two users into " + databaseUrl);

            log.info("Added user " + userRepository.save(new User("asd", "123", "a@mail.ru", 23)));
            log.info("Added user " + userRepository.save(new User("qwe", "456", "b@mail.com", 25)));
            log.info("Added user " + userRepository.save(new User("zxc", "789", "c@mail.com", 25)));

            log.info("Added employee " + employeeRepository.save(new Employee("Bilbo Baggins", "manager")));
            log.info("Added employee " + employeeRepository.save(new Employee("Sam", "worker")));
            log.info("Added employee " + employeeRepository.save(new Employee("1", "9")));
            log.info("Added employee " + employeeRepository.save(new Employee("2", "8")));
            log.info("Added employee " + employeeRepository.save(new Employee("3", "7")));
            log.info("Added employee " + employeeRepository.save(new Employee("4", "6")));
            log.info("Added employee " + employeeRepository.save(new Employee("5", "5")));
        };
    }
}
