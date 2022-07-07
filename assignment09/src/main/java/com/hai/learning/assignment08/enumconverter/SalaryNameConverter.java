package com.hai.learning.assignment08.enumconverter;

import com.hai.learning.assignment08.entity.Salary;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import static com.hai.learning.assignment08.entity.Salary.SalaryName.*;

@Converter(autoApply = true)
public class SalaryNameConverter implements AttributeConverter<Salary.SalaryName, Integer> {

    // 600: Dev, Test: 700, Scrum Master: 1500, PM: 2000

    @Override
    public Integer convertToDatabaseColumn(Salary.SalaryName attribute) {
        return switch (attribute) {
            case DEV_SALARY -> 600;
            case TEST_SALARY -> 700;
            case SCRUM_MASTER_SALARY -> 1500;
            case PM_SALARY -> 2000;
        };
    }

    @Override
    public Salary.SalaryName convertToEntityAttribute(Integer dbData) {
        return switch (dbData) {
            case 600 -> DEV_SALARY;
            case 700 -> TEST_SALARY;
            case 1500 -> SCRUM_MASTER_SALARY;
            case 2000 -> PM_SALARY;
            default -> null;
        };
    }
}
