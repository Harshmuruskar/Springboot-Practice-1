package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.DepartmentDto;
import com.example.employeemanagement.entity.Department;
import com.example.employeemanagement.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;


    public List<DepartmentDto> getAllDepartment() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map(department -> modelMapper.map(
                        department, DepartmentDto.class
                )).collect(Collectors.toList());
    }

    public Optional<DepartmentDto> getDepartmentById(Long id) {
        return departmentRepository.findById(id).map(department -> modelMapper.map(department, DepartmentDto.class));

    }
}
