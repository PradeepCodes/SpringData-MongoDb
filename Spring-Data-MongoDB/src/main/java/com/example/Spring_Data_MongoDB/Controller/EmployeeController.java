package com.example.Spring_Data_MongoDB.Controller;

import com.example.Spring_Data_MongoDB.Exception.EmployeeNotFoundException;
import com.example.Spring_Data_MongoDB.Service.EmployeeService;
import org.springframework.ui.Model;
import com.example.Spring_Data_MongoDB.Model.Employee;
import com.example.Spring_Data_MongoDB.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "index";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/displayAll";
    }

    @GetMapping("/displayAll")
    public String displayAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "display";
    }

    @GetMapping("/display/{id}")
    public String displayById(@PathVariable String id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);  // throws if not found
        model.addAttribute("employee", employee);
        return "display";
    }
}
