package com.hai.advanced.a1ex2_a2ex1_a3ex2.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class QuestionTypeNameConverter implements AttributeConverter<QuestionType.QuestionTypeName, String> {
    @Override
    public String convertToDatabaseColumn(QuestionType.QuestionTypeName attribute) {
        return switch (attribute) {
            case ESSAY -> "Essay";
            case MULTIPLE_CHOICE -> "Multiple-Choice";
        };
    }

    @Override
    public QuestionType.QuestionTypeName convertToEntityAttribute(String dbData) {
        return switch (dbData) {
            case "Essay" -> QuestionType.QuestionTypeName.ESSAY;
            case "Multiple-Choice"-> QuestionType.QuestionTypeName.MULTIPLE_CHOICE;
            default -> throw new IllegalArgumentException("Unexpected value: " + dbData);
        };
    }
}
