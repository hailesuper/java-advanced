package com.hai.learning.assignment08.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class DepartmentDTO {
    private int id;

    private String name;

    private List<AccountDTO> accounts;

    @Data
    @NoArgsConstructor
    static class AccountDTO {
        private short id;
        private String email;
        private String firstName;
        private String lastName;
    }
}
