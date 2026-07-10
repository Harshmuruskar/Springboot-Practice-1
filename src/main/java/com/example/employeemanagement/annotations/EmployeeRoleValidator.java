package com.example.employeemanagement.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.tomcat.util.bcel.Const;

import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeValidations, String > {
    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext context) {
        List<String> roles = List.of("USER", "ADMIN");
        return roles.contains(inputRole);

    }
}
