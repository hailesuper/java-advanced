package com.hai.learning.finalexam02.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDto {
    private int id;
    private String fullName;
    private String username;
    private String role;
    private List<GroupDto> groups;

    @Data
    @NoArgsConstructor
    static class GroupDto {
        private int id;
        private String name;
        private int totalMember;
        private LocalDate createDate;
    }
}
