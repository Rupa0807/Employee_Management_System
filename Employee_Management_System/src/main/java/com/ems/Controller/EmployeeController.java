package com.ems.Controller;

import com.ems.Entity.Employee;
import com.ems.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        setUpperCase(employee);
        employeeService.save(employee);

        return "redirect:/";
    }

    @GetMapping("/updateEmployee/{id}")
    public ModelAndView updateEmployee(@PathVariable("id") int id , ModelAndView modelandView){
       Employee emp= employeeService.getEmployeebyId(id);
        System.out.println("employee by Id: "+ emp);
        modelandView.setViewName("updateEmp");
       modelandView.addObject("employee", emp);

        return modelandView;
    }

    @RequestMapping ("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
     employeeService.deleteEmployee(id);
      return "redirect:/";

    }

    @RequestMapping("/SaveupdateEmployee")
    public String SaveupdateEmployee(@ModelAttribute("employee") Employee employee){
        setUpperCase(employee);
        employeeService.save(employee);

        return "redirect:/";
    }

    void setUpperCase(Employee employee){
        employee.setFirstName(employee.getFirstName().toUpperCase());
        employee.setLastName(employee.lastName.toUpperCase());
    }
}
