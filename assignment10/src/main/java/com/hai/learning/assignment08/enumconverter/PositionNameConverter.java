package com.hai.learning.assignment08.enumconverter;

import com.hai.learning.assignment08.entity.Position;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import static com.hai.learning.assignment08.entity.Position.PositionName.*;

@Converter(autoApply = true)
public class PositionNameConverter implements AttributeConverter<Position.PositionName, String> {
    @Override
    public String convertToDatabaseColumn(Position.PositionName attribute) {
        return switch (attribute) {

            case DEV -> "Dev";
            case TEST -> "Test";
            case SCUM_MASTER -> "ScrumMaster";
            case PM -> "PM";
        };
    }

    @Override
    public Position.PositionName convertToEntityAttribute(String dbData) {
        return switch (dbData) {
            case "Dev" -> DEV;
            case "Test" -> TEST;
            case "ScrumMaster" -> SCUM_MASTER;
            case "PM" -> PM;
            default -> null;
        };
    }
}
