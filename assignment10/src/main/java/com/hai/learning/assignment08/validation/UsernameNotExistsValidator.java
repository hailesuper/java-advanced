package com.hai.learning.assignment08.validation;

import com.hai.learning.assignment08.service.IAccountService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class UsernameNotExistsValidator implements ConstraintValidator<UsernameNotExists, String> {
    @Autowired
    private IAccountService accountService;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(username))
            return true;
        return !accountService.isAccountExistsByUsername(username);    }
}
