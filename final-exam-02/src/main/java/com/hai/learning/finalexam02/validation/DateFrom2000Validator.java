package com.hai.learning.finalexam02.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;

public class DateFrom2000Validator implements ConstraintValidator<DateFrom2000, LocalDate> {
    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (ObjectUtils.isEmpty(value))
            return true;
        return value.isAfter(LocalDate.of(2000,1,1));
    }
}
