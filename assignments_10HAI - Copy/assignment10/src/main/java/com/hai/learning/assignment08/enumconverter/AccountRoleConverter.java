package com.hai.learning.assignment08.enumconverter;

import com.hai.learning.assignment08.entity.Account;
import jakarta.persistence.AttributeConverter;

import static com.hai.learning.assignment08.entity.Account.Role.*;

public class AccountRoleConverter implements AttributeConverter<Account.Role, String> {
    @Override
    public String convertToDatabaseColumn(Account.Role attribute) {
        return switch (attribute) {

            case ADMIN -> "ADMIN";
            case EMPLOYEE -> "EMPLOYEE";
            case MANAGER -> "MANAGER";
            default -> null;
        };
    }

    @Override
    public Account.Role convertToEntityAttribute(String dbData) {
        return switch (dbData) {
            case "ADMIN" -> ADMIN;
            case "EMPLOYEE" -> EMPLOYEE;
            case "MANAGER" -> MANAGER;
            default -> null;
        };
    }
}
