package com.hai.learning.finalexam02.form;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateGroupNameForm {
    @Pattern(regexp = "^[a-zA-Z0-9\\s]{6,30}$", message = "Group name must be between 6-30 characters without special characters")
    private String name;
}
