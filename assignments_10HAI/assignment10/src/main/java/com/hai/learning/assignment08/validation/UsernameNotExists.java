package com.hai.learning.assignment08.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = UsernameNotExistsValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(UsernameNotExists.List.class)
public @interface UsernameNotExists {
    String message() default "{Account.getAllAccounts.form.username.UsernameNotExists}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        UsernameNotExists[] value();
    }
}
