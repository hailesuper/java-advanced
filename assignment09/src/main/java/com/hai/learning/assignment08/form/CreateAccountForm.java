package com.hai.learning.assignment08.form;

import com.hai.learning.assignment08.validation.EmailNotExists;
import com.hai.learning.assignment08.validation.UsernameNotExists;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CreateAccountForm {
    @Email
    @EmailNotExists
    private String email;

    @Length(min = 6, max = 50, message = "{Account.getAllAccounts.form.username.Length}")
    @UsernameNotExists
    private String username;

    private String firstName;
    private String lastName;
    private Integer departmentId;
    private Integer positionId;
    private Integer salaryId;
    @PastOrPresent
    private LocalDate createDate;
}
