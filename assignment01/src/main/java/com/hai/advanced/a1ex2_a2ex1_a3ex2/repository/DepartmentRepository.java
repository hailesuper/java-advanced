package com.hai.advanced.a1ex2_a2ex1_a3ex2.repository;

import com.hai.advanced.a1ex2_a2ex1_a3ex2.entity.Department;
import com.hai.advanced.a1ex2_a2ex1_a3ex2.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class DepartmentRepository {
    private final HibernateUtils hibernateUtils;

    public DepartmentRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public Department createDepartment(String departmentName) {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            var tempDepartment = new Department(departmentName);
            session.persist(tempDepartment);
            session.getTransaction().commit();
            return tempDepartment;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Department> getAllDepartments() {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            var departments = session.createSelectionQuery("FROM Department", Department.class)
                    .getResultList();
            session.getTransaction().commit();
            return departments;
        }
    }

    public Department getDepartmentById(int departmentID) {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            var department = session.get(Department.class, departmentID);
            session.getTransaction().commit();
            return department;
        }
    }

    public Department getDepartment(Department departmentIn) {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            var department = session.get(Department.class, departmentIn.getId());
            session.getTransaction().commit();
            return department;
        }
    }

    public Department getDepartmentByDepartmentName(String departmentName) {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            var DepartmentByNameQuery = session.createSelectionQuery("FROM Department WHERE departmentName=:paramDepartmentName", Department.class);
            DepartmentByNameQuery.setParameter("paramDepartmentName", departmentName);
            var Department = DepartmentByNameQuery.getSingleResult();
            session.getTransaction().commit();
            return Department;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteDepartmentById(int departmentID) {
        Session session = null;
        try {
            var tempDepartment = getDepartmentById(departmentID);
            session = hibernateUtils.getSession();
            session.beginTransaction();
            session.remove(tempDepartment);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            assert session != null;
            session.close();
        }
    }
}
