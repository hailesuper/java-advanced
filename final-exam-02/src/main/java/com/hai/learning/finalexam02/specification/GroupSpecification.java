package com.hai.learning.finalexam02.specification;

import com.hai.learning.finalexam02.entity.Group;
import com.hai.learning.finalexam02.form.filter.GroupFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class GroupSpecification {
    // build Specification
    public static Specification<Group> buildWhere(String search, GroupFilterForm groupFilterForm) {
        Specification<Group> where = null;

        // Search
        if (!StringUtils.isEmpty(search)) {
            var name = new CustomGroupSpecification("name",search);
            where = Specification.where(name);
        }

        // minID
        if (groupFilterForm != null && groupFilterForm.getMinID() != null) {
            var minID = new CustomGroupSpecification("minID", groupFilterForm.getMinID());
            if (where == null) {
                where = Specification.where(minID);
            } else {
                where = where.and(minID);
            }
        }

        // maxID
        if (groupFilterForm != null && groupFilterForm.getMaxID() != null) {
//            var maxID = Specification.where(new CustomGroupSpecification("maxID", groupFilterForm.getMaxID()));
            var maxID = new CustomGroupSpecification("maxID", groupFilterForm.getMaxID());

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
class CustomGroupSpecification implements Specification<Group> {
    @NonNull
    private String specFieldName;

    @NonNull
    private Object value;


    @Override
    public Predicate toPredicate(Root<Group> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
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
