package com.andrewn.java2304springmvc.repository;

import com.andrewn.java2304springmvc.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);

    List<Employee> findByNameContaining(String containsName);
}
