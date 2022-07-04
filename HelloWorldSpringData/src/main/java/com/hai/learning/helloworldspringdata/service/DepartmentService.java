package com.hai.learning.helloworldspringdata.service;

import com.hai.learning.helloworldspringdata.entity.Department;
import com.hai.learning.helloworldspringdata.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getByDepartmentName(String departmentName) {
        return departmentRepository.getByDepartmentName(departmentName);
    }

    @Override
    public List<Department> getDepartmentContainString(String innerString) {
        return departmentRepository.getDepartmentContainString(innerString);
    }
}
