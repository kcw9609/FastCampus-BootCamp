package com.example.hello_springboot.validator;

import com.example.hello_springboot.annotation.PhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    private String regxp;


    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        this.regxp = constraintAnnotation.regxp();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        boolean result = Pattern.matches(regxp, value);
        return result;
    }
}
