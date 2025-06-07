package com.example.Spring_Data_MongoDB.Controller;

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
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "index";
    }

    // Save employee to DB
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/displayAll";
    }

    // Display all employees
    @GetMapping("/displayAll")
    public String displayAllEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "display";
    }

    // Display employee by ID
    @GetMapping("/display/{id}")
    public String displayById(@PathVariable String id, Model model) {
        Optional<Employee> emp = employeeRepository.findById(id);
        model.addAttribute("employee", emp.orElse(null));
        return "display";
    }
}
