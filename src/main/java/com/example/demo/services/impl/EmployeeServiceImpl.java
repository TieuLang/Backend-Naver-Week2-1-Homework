package com.example.demo.services.impl;

import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.entities.Employee;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee getOne(Long id) {
        return employeeRepository.findById(id).orElseThrow();
    }
    @Override
    public Employee saveOrUpdate(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Override
    public boolean delete(Long id) {
        try {
            employeeRepository.deleteById(id);
        }catch (Exception e) {
            return false;
        }
        return true;
    }
}
