package com.hai.learning.assignment05.repository;

import com.hai.learning.assignment05.entity.Department;

import java.util.List;

public interface IDepartmentRepository {
    // Create
    boolean createDepartment(String departmentName);
    // Read
    List<Department> getAllDepartments();

    Department getDepartmentById(int departmentId);

    Department getDepartmentByName();

    // Update
    boolean updateDepartmentById();

    boolean updateDepartmentByName();
    // Delete

    boolean deleteDepartmentById();

    boolean deleteDepartmentByName();
}
