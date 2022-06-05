package com.hai.advanced.a1ex2_a2ex1.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PositionTypeConverter implements AttributeConverter<Position.PositionType, String> {
    @Override
    public String convertToDatabaseColumn(Position.PositionType attribute) {
        return switch (attribute) {
            case PM -> "PM";
            case DEV -> "Dev";
            case TEST -> "Test";
            case SCRUM_MASTER -> "Scrum Master";
        };
    }

    @Override
    public Position.PositionType convertToEntityAttribute(String dbData) {
        return switch (dbData) {
            case "PM" -> Position.PositionType.PM;
            case "Dev" -> Position.PositionType.DEV;
            case "Test" -> Position.PositionType.TEST;
            case "Scrum Master" -> Position.PositionType.SCRUM_MASTER;
            default -> throw new IllegalArgumentException("Unexpected value: " + dbData);
        };
    }
}
