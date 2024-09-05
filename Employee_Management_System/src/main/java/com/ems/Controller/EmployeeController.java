package com.ems.Controller;

import com.ems.Entity.Employee;
import com.ems.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {
@Autowired
    EmployeeService employeeService;

@GetMapping("/")
    public String displayHomePage(Model model){
   // model.addAttribute("getAllEmployees",employeeService.getAllEmployees());
    return findMyPages(1,model);
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

    /* For pagination:
    1. JpaRepository extends PagingAndSortingRepository , need not explicitly extend it
    2. Create a method(CreatePages) of type Page<Employee> in Service Class passing (pageNo, MaxItemsPerPage) as arguments
    3. Define the method CreatePages() in ServiceImpl class
       -> Pass the arguments to the PageRequest Class
       -> PageRequest pageable= PageRequest.of(pageNo,maxItemPerPage);
    4.In Controller, add the logic to create Pagination as below

    * */
    @RequestMapping("/page/{PageNo}")
    public  String findMyPages(@PathVariable("PageNo") int pageNo, Model model){
    int maxPageItems=5; //max items to be dispalyed per page;

    Page<Employee> page=employeeService.createPages(pageNo,maxPageItems);
       List < Employee > EmployeeList = page.getContent();
        System.out.println(page.getContent());

        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("getAllEmployees",EmployeeList);

        return "index";

    }
}
