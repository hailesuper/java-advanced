package com.hai.learning.assignment06spring2.repository;

import com.hai.learning.assignment06spring2.entity.Department;
import com.hai.learning.assignment06spring2.utils.HibernateUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
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

    @Override
    @Transactional
    public List<Department> getAllDepartments() {
        try (var session = hibernateUtils.getSession()) {
//            session.beginTransaction();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Department> criteriaQuery = criteriaBuilder.createQuery(Department.class);
            Root<Department> departmentRoot = criteriaQuery.from(Department.class);
            criteriaQuery.select(departmentRoot);

            List<Department> departments = session.createQuery(criteriaQuery).getResultList();

//            session.getTransaction().commit();
            return departments;
        }
    }

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
