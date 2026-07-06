package com.example.employeemanagement.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;

    @NotBlank(message = "Name should not be blank")
    private String name;

    @Email(message = "Email is required")
    @NotBlank(message = "Email is not null")
    private String email;

    @Max(value = 80 , message = "Age is not more than 80")
    @Min(value= 18 , message = "Age should not less than 18")
    private Integer age;

    @NotBlank(message = "Role cannnot be blank")
    @Pattern(regexp = "^(ADMIN|USER)$", message = "The role of Employee should be ADMIN or USER")
    private String Role;

    @NotNull(message = "Salary should be not null ") @Positive(message = "Salary of Employee should be positive ")
    private Integer Salary;

    private LocalDate dateOfJoining;
    private boolean isActive;
}
