package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.EmployeeDto;
import com.example.employeemanagement.entity.EmployeeEntity;
import com.example.employeemanagement.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;


import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    public Optional<EmployeeDto> getEmployeeById(Long id){
        return employeeRepository.findById(id).map( employeeEntity -> modelMapper.map(employeeEntity, EmployeeDto.class));
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

    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long id) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
        employeeEntity.setId(id);
        EmployeeEntity savedEntity=employeeRepository.save(employeeEntity);
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }

    public boolean existsByEmployeeId(Long id){
        return employeeRepository.existsById(id);
    }

    public boolean deleteEmployeeById(Long id) {
        boolean exists = existsByEmployeeId(id);
        if(!exists) return false;
        employeeRepository.deleteById(id);
        return true;
    }

    public EmployeeDto updatePartialEmployeeId(Long id, Map<String, Object> updates) {
        boolean exists = existsByEmployeeId(id);
        if (!exists) return null;
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        updates.forEach((field , value)->{
            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class, field );
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated,employeeEntity,value );
        });
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDto.class);

    }

}
