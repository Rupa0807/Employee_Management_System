package com.ems.Service;

import com.ems.Entity.Employee;
import com.ems.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
       return employeeRepository.findAll();
    }
}
