package com.example.demo.services.impl;

import com.example.demo.entities.Department;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
    @Override
    public Department getOne(Long id) {
        return departmentRepository.findById(id).orElseThrow();
    }
    @Override
    public Department saveOrUpdate(Department Department) {
        return departmentRepository.save(Department);
    }
    @Override
    public boolean delete(Long id) {
        try {
            departmentRepository.deleteById(id);
        }catch (Exception e) {
            return false;
        }
        return true;
    }
}
