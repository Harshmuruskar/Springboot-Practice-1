package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.EmployeeDto;
import com.example.employeemanagement.entity.EmployeeEntity;
import com.example.employeemanagement.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    public EmployeeDto getEmployeeById(Long id){
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
       return modelMapper.map(employeeEntity, EmployeeDto.class);
    }


    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        return employeeEntities.stream()
                .map(employeeEntity ->
                        modelMapper.map(employeeEntity, EmployeeDto.class))
                .collect(Collectors.toList());
    }


    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        EmployeeEntity toSaveEntity = modelMapper.map(employeeDto , EmployeeEntity.class);
        EmployeeEntity employeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(employeeEntity , EmployeeDto.class);
    }
}
