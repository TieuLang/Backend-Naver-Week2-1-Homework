package com.example.demo.dtos;

import com.example.demo.entities.Employee;
import lombok.*;

import javax.persistence.Column;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentDTO {
    private String name;

    private String description;

    private List<Employee> employeeDTOS;
}
