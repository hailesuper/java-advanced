package com.hai.learning.finalexam02.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class UserLoginDto {
    private int id;
    private String fullName;
    private String username;
    private String role;
}
