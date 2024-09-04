package com.ems.Service;

import com.ems.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    public List<Employee> getAllEmployees();

    void save(Employee employee);

    Employee getEmployeebyId(int id);
}
