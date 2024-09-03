package com.ems.Controller;

import com.ems.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class EmployeeController {
@Autowired
    EmployeeService employeeService;

@GetMapping("/")
    public String displayHomePage(Model model){
        model.addAttribute("getAllEmployees",employeeService.getAllEmployees());
    return "index";
    }
}
