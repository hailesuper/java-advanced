package com.hai.learning.assignment08.entity;

import jakarta.persistence.AttributeConverter;

public class PositionNameConverter implements AttributeConverter<Position.PositionName, String> {
    @Override
    public String convertToDatabaseColumn(Position.PositionName attribute) {
        return switch (attribute) {

            case DEV -> null;
            case TEST -> null;
            case SCUM_MASTER -> null;
            case PM -> null;
        };
    }

    @Override
    public Position.PositionName convertToEntityAttribute(String dbData) {
        return null;
    }
}
