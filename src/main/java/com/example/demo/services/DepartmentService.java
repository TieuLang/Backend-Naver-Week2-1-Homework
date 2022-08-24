package com.example.demo.services;

import com.example.demo.entities.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAll();

    Department getOne(Long id);

    Department saveOrUpdate(Department Department);

    boolean delete(Long id);
}
