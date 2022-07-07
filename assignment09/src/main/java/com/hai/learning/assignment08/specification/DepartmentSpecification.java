package com.hai.learning.assignment08.specification;

import com.hai.learning.assignment08.entity.Department;
import com.hai.learning.assignment08.form.DepartmentFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class DepartmentSpecification {
    // build Specification
    public static Specification<Department> buildWhere(String search, DepartmentFilterForm departmentFilterForm) {
        Specification<Department> where = null;

        // Search
        if (!StringUtils.isEmpty(search)) {
            var name = new CustomDepartmentSpecification("name",search);
            where = Specification.where(name);
        }

        // minID
        if (departmentFilterForm != null && departmentFilterForm.getMinID() != null) {
            var minID = new CustomDepartmentSpecification("minID", departmentFilterForm.getMinID());
            if (where == null) {
                where = Specification.where(minID);
            } else {
                where = where.and(minID);
            }
        }

        // maxID
        if (departmentFilterForm != null && departmentFilterForm.getMaxID() != null) {
//            var maxID = Specification.where(new CustomDepartmentSpecification("maxID", departmentFilterForm.getMaxID()));
            var maxID = new CustomDepartmentSpecification("maxID", departmentFilterForm.getMaxID());

            if (where == null) {
                where = Specification.where(maxID);
            } else {
                where = where.and(maxID);
            }
        }

        return where;

    }
}

@RequiredArgsConstructor
class CustomDepartmentSpecification implements Specification<Department> {
    @NonNull
    private String specFieldName;

    @NonNull
    private Object value;


    @Override
    public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (specFieldName.equalsIgnoreCase("name"))
            return criteriaBuilder.like(root.get("name"),"%" + value + "%");

        // minID
        if (specFieldName.equalsIgnoreCase("minID"))
            return criteriaBuilder.greaterThanOrEqualTo(root.get("id"), value.toString());

        // maxID
        if (specFieldName.equalsIgnoreCase("maxID"))
            return criteriaBuilder.lessThanOrEqualTo(root.get("id"),value.toString());
        return null;

    }
}
