package com.example.demo.controller;

import com.example.demo.dtos.DepartmentDTO;
import com.example.demo.entities.Department;
import com.example.demo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value="/")
    public ResponseEntity<List<Department>> getListDepartments() {
        return  new ResponseEntity<>(departmentService.getAll(), HttpStatus.OK);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable Long id) {
        return new ResponseEntity<>(departmentService.getOne(id), HttpStatus.OK);
    }

    @PostMapping(value="/add")
    public ResponseEntity<Department> insertDepartment(DepartmentDTO dto) {
        Department entity = new Department(0L,dto.getName(),dto.getDescription(),dto.getEmployeeDTOS());
        return new ResponseEntity<>(departmentService.saveOrUpdate(entity), HttpStatus.OK);
    }
    @PutMapping(value="/edit/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id,DepartmentDTO dto) {
        Department entity = new Department(id,dto.getName(),dto.getDescription(),dto.getEmployeeDTOS());
        return new ResponseEntity<>(departmentService.saveOrUpdate(entity), HttpStatus.OK);
    }
    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable Long id) {
        return new ResponseEntity<>(departmentService.delete(id), HttpStatus.OK);
    }



}

