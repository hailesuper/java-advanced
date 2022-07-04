package com.hai.learning.assignment08.specification;

import com.hai.learning.assignment08.entity.Department;
import com.hai.learning.assignment08.form.DepartmentFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class DepartmentSpecification {
    // build Specification
    public static Specification<Department> buildWhere(String search) {
        Specification<Department> where = null;

        // Search
        if (!StringUtils.hasLength(search)) {
            where = Specification.where(new CustomDepartmentSpecification("name",search));
        }
        return where;
    }
}

@Data
class CustomDepartmentSpecification implements Specification<Department> {
    @NonNull
    private String specFieldName;

    @NonNull
    private Object value;


    @Override
    public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (specFieldName.equalsIgnoreCase("name"))
            return criteriaBuilder.like(root.get("name"),"%" + value + "%");
        return null;
    }
}
