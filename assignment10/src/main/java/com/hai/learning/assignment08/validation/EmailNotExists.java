package com.hai.learning.assignment08.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Constraint(validatedBy = EmailNotExistsValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(EmailNotExists.List.class)
public @interface EmailNotExists {
    String message() default "{Account.getAllAccounts.form.email.EmailNotExists}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        EmailNotExists[] value();
    }
}
