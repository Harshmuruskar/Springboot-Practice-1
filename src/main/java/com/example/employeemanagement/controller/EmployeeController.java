package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeDto;
import com.example.employeemanagement.entity.EmployeeEntity;
import com.example.employeemanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        Optional<EmployeeDto> employeeDto = employeeService.getEmployeeById(id);
        return employeeDto.map(employeeDto1 ->
                ResponseEntity.ok(employeeDto1)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee =employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto,
                                      @PathVariable Long id) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDto, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean>  deleteEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.deleteEmployeeById(id));

    }

    @PatchMapping("{id}")
    public ResponseEntity<EmployeeDto> updatePartialEmployeeById(@RequestBody Map<String, Object> updates,
                                                 @PathVariable Long id){
        return ResponseEntity.ok(employeeService.updatePartialEmployeeId(id,updates));
    }

}
