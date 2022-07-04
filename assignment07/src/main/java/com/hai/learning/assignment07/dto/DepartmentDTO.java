package com.hai.learning.assignment07.dto;

import com.hai.learning.assignment07.entity.Department;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    @NonNull
    private String name;

    public Department toEntity() {
        return new Department(name);
    }
}
