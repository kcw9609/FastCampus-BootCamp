package com.example.hello_springboot.validator;

import com.example.hello_springboot.annotation.PhoneNumber;
import com.example.hello_springboot.annotation.YearMonth;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;


public class YearMonthFormatValidator implements ConstraintValidator<YearMonth, String> {

    private String type;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.type = constraintAnnotation.type();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            java.time.YearMonth.parse(value, DateTimeFormatter.ofPattern(type));
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}