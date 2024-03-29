package com.hai.learning.assignment08.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AccountDTO {
    private short id;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String departmentName;
    private String positionName;
    private String salaryName;
    private LocalDate createDate;
    private String role;
}
