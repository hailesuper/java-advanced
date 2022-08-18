package com.hai.learning.assignment08.form;

import com.hai.learning.assignment08.entity.Department;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class DepartmentForm {

    @NonNull
    private String name;

    public Department toEntity() {
        return new Department(name);
    }
}
