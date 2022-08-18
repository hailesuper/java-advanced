package com.hai.learning.assignment08.validation;

import com.hai.learning.assignment08.service.IAccountService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class EmailNotExistsValidator implements ConstraintValidator<EmailNotExists, String> {
    @Autowired
    private IAccountService accountService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(email))
            return true;
        return !accountService.isAccountExistsByEmail(email);
    }
}
