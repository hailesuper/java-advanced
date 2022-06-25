package com.hai.learning.assignment06.repository;

import com.hai.learning.assignment06.entity.Department;

import java.util.List;

public interface IDepartmentRepository {
    List<Department> getAllDepartments();

    Department getDepartmentById(int id);

    List<Department> getDepartmentsWithCriteria(int pageNumber, int pageSize, String departmentNameSearch, String sortBy, String sortType);
}
