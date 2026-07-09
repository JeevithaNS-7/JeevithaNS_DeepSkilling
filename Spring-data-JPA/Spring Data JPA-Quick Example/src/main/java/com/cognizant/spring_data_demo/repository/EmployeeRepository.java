package com.cognizant.spring_data_demo.repository;

import com.cognizant.spring_data_demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository
        extends JpaRepository<Employee, Integer> {

}
