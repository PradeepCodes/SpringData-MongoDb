package com.example.Spring_Data_MongoDB.Service.Impl;

import com.example.Spring_Data_MongoDB.Exception.EmployeeNotFoundException;
import com.example.Spring_Data_MongoDB.Model.Employee;
import com.example.Spring_Data_MongoDB.Repository.EmployeeRepository;
import com.example.Spring_Data_MongoDB.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + id));
    }
}
