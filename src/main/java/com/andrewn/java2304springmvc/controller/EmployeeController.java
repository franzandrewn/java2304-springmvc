package com.andrewn.java2304springmvc.controller;

import com.andrewn.java2304springmvc.exception.EmployeeNotFoundException;
import com.andrewn.java2304springmvc.model.Employee;
import com.andrewn.java2304springmvc.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(
            @RequestParam(name="name", required = false, defaultValue = "") String filterByName) {
        if (filterByName.isEmpty()) {
            return repository.findAll();
        } else {
            return repository.findByNameContaining(filterByName);
        }

    }

    @GetMapping("/employees/pages/{pagenum}")
    public List<Employee> getEmployeesWithPagination(@PathVariable("pagenum") Integer pagenum) {
        Pageable pageable = PageRequest.of(pagenum-1, 3, Sort.by("name"));
        return repository.findAll(pageable).getContent();
    }

    @GetMapping("/employees/{id}")
    public Employee getOneEmployee(@PathVariable(name="id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @DeleteMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable(name="id") Long id) {
        repository.deleteById(id);
    }

    @PostMapping("/employees")
    public Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    @PutMapping("/employees/{id}")
    public Employee changeEmployee(@RequestBody Employee changeEmployee, @PathVariable(name="id") Long id) {
        return repository.findById(id)
                .map((employee) -> {
                    employee.setName(changeEmployee.getName());
                    employee.setRole(changeEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    changeEmployee.setId(id);
                    return repository.save(changeEmployee);
                });
    }
}
