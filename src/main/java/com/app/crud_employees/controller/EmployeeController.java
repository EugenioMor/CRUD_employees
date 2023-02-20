package com.app.crud_employees.controller;

import com.app.crud_employees.entity.Employee;
import com.app.crud_employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping({"/employees", "/"})
    public String listEmployees(Model model){
        model.addAttribute("employees", service.listAllEmployees());
        return "employees"; // Nos retorna al archivo "employees"
    }

    @GetMapping("/employees/new")
    public String showEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create_employee";
    }

    @PostMapping("/employees")
    public String saveEmployees(@ModelAttribute("employee") Employee employee){
        service.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        model.addAttribute("employee", service.getEmployeeById(id));
        return "edit_employee";
    }

    @PostMapping("employees/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model){
        Employee existentEmployee = service.getEmployeeById(id);
        existentEmployee.setId(id);
        existentEmployee.setName(employee.getName());
        existentEmployee.setLastname(employee.getLastname());
        existentEmployee.setEmail(employee.getEmail());

        service.updateEmployee(existentEmployee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
        return "redirect:/employees";
    }



}
