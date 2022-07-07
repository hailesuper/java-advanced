package com.hai.learning.assignment08.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountForm {
    private String email;
    private String firstName;
    private String lastName;
    private Integer departmentId;
    private Integer positionId;
}
