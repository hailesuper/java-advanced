package com.hai.learning.assignment08.service;

import com.hai.learning.assignment08.entity.Department;
import com.hai.learning.assignment08.form.DepartmentFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {
//    Page<Department> getAllDepartments(Pageable pageable, String search);
    Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFilterForm departmentFilterForm);


    Department getDepartmentById(short id);
    Department getDepartmentByName(String name);
    void createDepartment(Department department);
    void updateDepartment(short id, String newName);
    void updateDepartment(Department department);
    void deleteDepartment(short id);
    boolean isDepartmentExistsById(short id);
    boolean isDepartmentExistsByName(String name);
}
