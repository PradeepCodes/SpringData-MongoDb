package com.example.Spring_Data_MongoDB.Service;

import com.example.Spring_Data_MongoDB.Model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String id);
}
