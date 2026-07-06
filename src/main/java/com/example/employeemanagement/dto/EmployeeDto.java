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
    private String email;
    @Max(value = 80 , message = "Age is not more than 80")
    @Min(value= 18 , message = "Age should not less than 18")
    private Integer age;
    @Pattern(regexp = "^(ADMIN|USER)$", message = "The role of Employee should be ADMIN or USER")
    private String Role;
    private LocalDate dateOfJoining;
    private boolean isActive;
}
