package com.hai.learning.assignment08.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SalaryDTO {
    private short id;
    private String name;
    private List<SalaryDTO.AccountDTO> accounts;

    @Data
    @NoArgsConstructor
    static class AccountDTO {
        private short id;
        private String username;
        private String email;
        private String firstName;
        private String lastName;
    }
}
