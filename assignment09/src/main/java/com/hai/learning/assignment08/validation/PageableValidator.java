package com.hai.learning.assignment08.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.data.domain.Pageable;

public class PageableValidator implements
        ConstraintValidator<PageableConstraint, Pageable> {

    private int minPageSize;
    private int maxPageSize;

    private int minPageNumber;

    private int maxSearchCharacter;


//
//    int minPageSize() default 5;
//    int maxPageSize() default 20;
//
//    int minPageNumber() default 1;
//
//    int maxSearchCharacter() default 50;
//
//    // Paging: pageNumber >= 1, 5 <= pageSize <= 20
//    //o Search: không được quá 50 characters, không chứa các ký tự
//    //đặc biệt, ...

    @Override
    public void initialize(PageableConstraint constraintAnnotation) {
        minPageSize=constraintAnnotation.minPageSize();
        maxPageSize=constraintAnnotation.maxPageSize();
        minPageNumber=constraintAnnotation.minPageNumber();
    }

    @Override
    public boolean isValid(Pageable value, ConstraintValidatorContext context) {
        boolean flag =
                value.getPageSize() >= minPageSize && value.getPageSize() <= maxPageSize
                && value.getPageNumber() + 1 >= minPageNumber;
        return flag;
    }
}
