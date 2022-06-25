package com.hai.learning.assignment06.service;

import com.hai.learning.assignment06.entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> getAllDepartments();

    Department getDepartmentById(int id);

    List<Department> getDepartmentsWithCriteria(int pageNumber, int pageSize, String departmentNameSearch, String sortBy, String sortType);

}
