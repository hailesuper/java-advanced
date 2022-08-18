package com.hai.learning.finalexam02.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class GroupDto {
    private int id;
    private String name;
    private int totalMember;
    private UserDto creator;
    @JsonFormat(pattern = "yyyy-MMM-dd")
    private LocalDate createDate;

    @Data
    @NoArgsConstructor
    static class UserDto {
        private int id;
        private String fullName;
        private String username;
        private String role;
    }
}
