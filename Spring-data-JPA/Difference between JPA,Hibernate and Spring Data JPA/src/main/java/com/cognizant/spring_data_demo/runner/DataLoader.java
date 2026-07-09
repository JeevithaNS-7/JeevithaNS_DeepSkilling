package com.cognizant.spring_data_demo.runner;

import com.cognizant.spring_data_demo.entity.Employee;
import com.cognizant.spring_data_demo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository repository;

    public DataLoader(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {

        repository.save(new Employee("John"));

        repository.save(new Employee("Alice"));

        repository.findAll().forEach(emp ->
                System.out.println(emp.getName()));
    }
}