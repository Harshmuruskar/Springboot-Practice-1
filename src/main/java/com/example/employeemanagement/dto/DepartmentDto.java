package com.example.employeemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long id;
    @NotBlank(message = "Title is requied")
    private String title;

    private boolean isActive;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
