package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeDto;
import com.example.employeemanagement.entity.EmployeeEntity;
import com.example.employeemanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public EmployeeDto getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.createEmployee(employeeDto);

    }

}
