package com.example.demo.dtos;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    private String name;

    private LocalDate birthDate;

    private String gender;

    private Long deptId;

}
