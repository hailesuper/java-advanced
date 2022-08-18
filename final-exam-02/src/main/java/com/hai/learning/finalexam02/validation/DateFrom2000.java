package com.hai.learning.finalexam02.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = DateFrom2000Validator.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(DateFrom2000.List.class)
public @interface DateFrom2000 {
    String message() default "Date must be from year 2000";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        DateFrom2000[] value();
    }
}
