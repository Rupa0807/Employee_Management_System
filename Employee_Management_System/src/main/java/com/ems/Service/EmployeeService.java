package com.ems.Service;

import com.ems.Entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    public List<Employee> getAllEmployees();

    void save(Employee employee);

    Employee getEmployeebyId(int id);

    void deleteEmployee(int id);

    Page<Employee> createPages(int pageNo,int totalPages);
}
