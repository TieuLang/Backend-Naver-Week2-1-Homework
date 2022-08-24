package com.example.demo.controller;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
import com.example.demo.services.DepartmentService;
import com.example.demo.services.EmployeeService;
import com.example.demo.services.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Employee>> getListEmployees() {
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getOne(id), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Employee> insertEmployee(EmployeeDTO dto) {
        Employee entity = new Employee(0L, dto.getName(), dto.getBirthDate(), dto.getGender(), departmentService.getOne(dto.getDeptId()));
        return new ResponseEntity<>(employeeService.saveOrUpdate(entity), HttpStatus.OK);
    }

    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, EmployeeDTO dto) {
        Employee entity = new Employee(id, dto.getName(), dto.getBirthDate(), dto.getGender(), departmentService.getOne(dto.getDeptId()));
        return new ResponseEntity<>(employeeService.saveOrUpdate(entity), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.delete(id), HttpStatus.OK);
    }
}
