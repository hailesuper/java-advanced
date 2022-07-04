package com.hai.learning.assignment06.repository;

import com.hai.learning.assignment06.entity.Department;
import com.hai.learning.assignment06.utils.HibernateUtils;

import jakarta.persistence.criteria.*;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.*;
import java.util.List;

@Repository
public class DepartmentRepository implements IDepartmentRepository {
    private final HibernateUtils hibernateUtils;

    public DepartmentRepository() {
        this.hibernateUtils = HibernateUtils.getInstance();
    }

//    public List<Department> getAllDepartments() {
//        try (var session = hibernateUtils.getSession()) {
//            session.beginTransaction();
//            var selectionQuery = session.createQuery("FROM Department", Department.class);
//            var departments = selectionQuery.getResultList();
//            session.getTransaction().commit();
//            return departments;
//        }
//    }

    /**
     * Querry - HQL
     * Native verrsion hibernate ->
     * Quả ly ssion and tcation ->
     * native sql -> mapping tay neu re sult thuc 2 bang -ko map vs entity nao
     * select * from -> maop entity biubh thuong
     * conffig EntityScan...-> must have
     *
     * @return
     */
    @Override
    public List<Department> getAllDepartments() {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Department> criteriaQuery = criteriaBuilder.createQuery(Department.class);
            Root<Department> departmentRoot = criteriaQuery.from(Department.class);
            criteriaQuery.select(departmentRoot);

            List<Department> departments = session.createQuery(criteriaQuery).getResultList();

            session.getTransaction().commit();
            return departments;
        }
    }

//    @Override
//    public List<Department> getAllDepartments() {
//        try (var session = hibernateUtils.getSession()) {
//            CriteriaBuilder cb = session.getCriteriaBuilder();
//            CriteriaQuery<Department> cr = cb.createQuery(Department.class);
//            Root<Department> root = cr.from(Department.class);
//            cr.select(root);
//
//            List<Department> results = session.createQuery(cr).getResultList();
//            return results;
//        }
//    }

    @Override
    public Department getDepartmentById(int id) {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            var department = session.get(Department.class, id);
            session.getTransaction().commit();
            return department;
        }
    }

    /**
     * <a href="https://www.baeldung.com/hibernate-criteria-queries">JPA Criteria Queries</a>
     * <a href="https://www.baeldung.com/jpa-pagination">...</a>
     * @param departmentNameSearch
     * @param sortBy
     * @param sortType
     * @return
     */
    @Override
    public List<Department> getDepartmentsWithCriteria(int pageNumber, int pageSize, String departmentNameSearch, String sortBy, String sortType) {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Department> cq = cb.createQuery(Department.class);
            Root<Department> departmentRoot = cq.from(Department.class);
            cq.select(departmentRoot);

            // Filter
            cq.where(cb.like(departmentRoot.get("departmentName"), "%" + departmentNameSearch + "%"));

            // Sort
            if (sortType.equalsIgnoreCase("desc"))
                cq.orderBy(cb.desc(departmentRoot.get(sortBy)));
            else
                cq.orderBy(cb.asc(departmentRoot.get(sortBy)));

            // Pagination
            TypedQuery<Department> typedQuery = session.createQuery(cq);
            typedQuery.setFirstResult((pageNumber - 1) * pageSize);
            typedQuery.setMaxResults(pageSize);

            // Get the result
            var departments = typedQuery.getResultList();
            session.getTransaction().commit();
            return departments;
        }
    }
}
