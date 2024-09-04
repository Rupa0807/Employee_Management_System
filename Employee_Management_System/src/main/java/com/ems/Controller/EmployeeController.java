package com.ems.Controller;

import com.ems.Entity.Employee;
import com.ems.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
@Autowired
    EmployeeService employeeService;

@GetMapping("/")
    public String displayHomePage(Model model){
        model.addAttribute("getAllEmployees",employeeService.getAllEmployees());
    return "index";
    }

    @GetMapping("/addEmployeeForm")
    public String AddEmployeeForm(Model model){
    Employee employee = new Employee();
    model.addAttribute("employee",employee);
    return "AddEmpForm";
    }

    @PostMapping("/SaveEmployee")
    public String SaveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);

        return "redirect:/";
    }
}
