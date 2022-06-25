package com.hai.learning.assignment05.repository;

import com.hai.learning.assignment05.entity.Department;
import com.hai.learning.assignment05.utils.HibernateUtils;

import java.util.List;

public class DepartmentRepository implements  IDepartmentRepository {

    private final HibernateUtils hibernateUtils;

    public DepartmentRepository() {
        this.hibernateUtils = HibernateUtils.getInstance();
    }

    @Override
    public boolean createDepartment(String departmentName) {

        return false;
    }

    @Override
    public List<Department> getAllDepartments() {
        try (var session = hibernateUtils.getSession()) {
//            session.beginTransaction();
            var getDepartmentQuery = session.createSelectionQuery("FROM Department", Department.class);
            var departments = getDepartmentQuery.getResultList();
//            session.getTransaction().commit();
            return departments;
        }
    }

    @Override
    public Department getDepartmentById(int departmentId) {
        try (var session = hibernateUtils.getSession()) {
            return session.get(Department.class, departmentId);
        }
    }

    @Override
    public Department getDepartmentByName() {
        return null;
    }

    @Override
    public boolean updateDepartmentById() {
        return false;
    }

    @Override
    public boolean updateDepartmentByName() {
        return false;
    }

    @Override
    public boolean deleteDepartmentById() {
        return false;
    }

    @Override
    public boolean deleteDepartmentByName() {
        return false;
    }
}
