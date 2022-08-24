package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String name;

    private LocalDate birthDate;

    private String gender;

    private Long deptId;

}
