package com.hai.learning.finalexam02.entity.enumconverter;

import com.hai.learning.finalexam02.entity.User;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import static com.hai.learning.finalexam02.entity.User.UserRole.*;

@Converter(autoApply = true)
public class UserRoleConverter implements AttributeConverter<User.UserRole, String> {
    @Override
    public String convertToDatabaseColumn(User.UserRole attribute) {
        return switch (attribute) {
            case USER -> "USER";
            case ADMIN -> "ADMIN";
            case MANAGER -> "MANAGER";
            default -> null;
        };
    }

    @Override
    public User.UserRole convertToEntityAttribute(String dbData) {
        return switch (dbData) {
            case "USER" -> USER;
            case "ADMIN" -> ADMIN;
            case "MANAGER" -> MANAGER;
            default -> throw new IllegalStateException("Unexpected value: " + dbData);
        };
    }
}
