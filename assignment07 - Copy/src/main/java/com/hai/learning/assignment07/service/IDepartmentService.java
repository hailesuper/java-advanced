package com.hai.learning.assignment07.service;

import com.hai.learning.assignment07.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {
    Page<Department> getAllDepartments(Pageable pageable);
    Department getDepartmentById(short id);
    Department getDepartmentByName(String name);
    void createDepartment(Department department);
    void updateDepartment(short id, String newName);
    void updateDepartment(Department department);
    void deleteDepartment(short id);
    boolean isDepartmentExistsById(short id);
    boolean isDepartmentExistsByName(String name);
}
