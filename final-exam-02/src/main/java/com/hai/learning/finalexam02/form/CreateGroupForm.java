package com.hai.learning.finalexam02.form;

import com.hai.learning.finalexam02.validation.DateFrom2000;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CreateGroupForm {
    @Pattern(regexp = "^[a-zA-Z0-9\\s]{6,30}$", message = "Group name must be between 6-30 characters without special characters")
    private String name;
    private int totalMember;
    private int creatorId;
    @PastOrPresent(message = "Created Date must be past or present.")
    @DateFrom2000
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;
}
