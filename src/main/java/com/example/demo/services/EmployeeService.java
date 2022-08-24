package com.example.demo.services;

import com.example.demo.entities.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee getOne(Long id);

    Employee saveOrUpdate(Employee employee);

    boolean delete(Long id);
}
