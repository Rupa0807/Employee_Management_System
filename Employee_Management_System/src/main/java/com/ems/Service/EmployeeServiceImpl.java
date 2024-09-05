package com.ems.Service;

import com.ems.Entity.Employee;
import com.ems.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
       return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeebyId(int id) {
      Optional<Employee> employee =  employeeRepository.findById(id);
      Employee emp=null;
      if(employee.isPresent()){
           emp= employee.get();
        }
      else throw new RuntimeException("Employee Id not found : "+ id);

      return emp;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> createPages(int pageNo, int maxItemPerPage) {
        Pageable pageable= PageRequest.of(pageNo-1,maxItemPerPage);
       // Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.employeeRepository.findAll(pageable);

    }
}
