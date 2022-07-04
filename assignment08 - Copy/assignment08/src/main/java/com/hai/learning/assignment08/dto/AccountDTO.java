package com.hai.learning.assignment08.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDTO {
    private short id;
    private String email;
    private String firstName;
    private String lastName;
    private String departmentName;
}
