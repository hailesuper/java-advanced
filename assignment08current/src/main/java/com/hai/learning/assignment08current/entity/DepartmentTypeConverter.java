package com.hai.learning.assignment08current.entity;

import javax.persistence.*;

import static com.hai.learning.assignment08current.entity.Department.DepartmentType.*;

@Converter(autoApply = true)
public class DepartmentTypeConverter implements AttributeConverter<Department.DepartmentType, String> {

    @Override
    public String convertToDatabaseColumn(Department.DepartmentType attribute) {
        return switch (attribute) {
            case TEST -> "Test";
            case DEV -> "Dev";
            case PM -> "PM";
            case SCUM_MASTER -> "ScumMaster";
            default -> null;
        };
    }

    @Override
    public Department.DepartmentType convertToEntityAttribute(String dbData) {
        return switch (dbData) {
            case "Test" -> TEST;
            case "Dev" -> DEV;
            case "PM" -> PM;
            case "ScumMaster" -> SCUM_MASTER;
            default -> null;
        };
    }
}
