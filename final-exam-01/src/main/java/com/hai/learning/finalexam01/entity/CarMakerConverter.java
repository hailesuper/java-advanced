package com.hai.learning.finalexam01.entity;

import jakarta.persistence.AttributeConverter;

public class CarMakerConverter implements AttributeConverter<Car.CarMaker, String> {
    @Override
    public String convertToDatabaseColumn(Car.CarMaker attribute) {
        return switch (attribute) {
            case HONDA -> "Honda";
            case TOYOTA -> "Toyota";
            default -> null;
        };
    }

    @Override
    public Car.CarMaker convertToEntityAttribute(String dbData) {
        return switch (dbData) {
            case "Honda" -> Car.CarMaker.HONDA;
            case "Toyota" -> Car.CarMaker.TOYOTA;
            default -> null;
        };
    }
}
