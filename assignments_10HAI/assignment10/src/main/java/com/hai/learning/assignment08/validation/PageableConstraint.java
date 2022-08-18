package com.hai.learning.assignment08.validation;

import jakarta.validation.*;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * <a href="https://stackoverflow.com/questions/47468250/how-can-i-validate-size-of-pageable">How can I validate size of Pageable?</a>
 */
@Constraint(validatedBy = PageableValidator.class)
@Target( { ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface PageableConstraint {
    String message() default "{Account.getAllAccounts.form.pageable.PageableConstraint}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int minPageSize() default 5;
    int maxPageSize() default 20;

    int minPageNumber() default 1;


    // Paging: pageNumber >= 1, 5 <= pageSize <= 20
    //o Search: không được quá 50 characters, không chứa các ký tự
    //đặc biệt, ...
}

