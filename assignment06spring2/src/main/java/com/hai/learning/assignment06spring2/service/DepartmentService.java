package com.hai.learning.assignment06spring2.service;

import com.hai.learning.assignment06spring2.entity.Department;
import com.hai.learning.assignment06spring2.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.getAllDepartments();
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentRepository.getDepartmentById(id);
    }

    @Override
    public List<Department> getDepartmentsWithCriteria(int pageNumber, int pageSize, String departmentNameSearch, String sortBy, String sortType) {
        return departmentRepository.getDepartmentsWithCriteria(pageNumber, pageSize, departmentNameSearch, sortBy, sortType);
    }
}
