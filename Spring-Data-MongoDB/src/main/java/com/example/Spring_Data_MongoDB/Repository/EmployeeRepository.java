package com.example.Spring_Data_MongoDB.Repository;

import com.example.Spring_Data_MongoDB.Model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
}
