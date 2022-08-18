package com.hai.learning.assignment08.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PositionDTO {
    private short id;
    private String name;
    private List<AccountDTO> accounts;

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
