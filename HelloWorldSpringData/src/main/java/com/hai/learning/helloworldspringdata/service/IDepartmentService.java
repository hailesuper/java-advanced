package com.hai.learning.helloworldspringdata.service;

import com.hai.learning.helloworldspringdata.entity.Department;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDepartmentService {
    public List<Department> getAllDepartments();

    Department getByDepartmentName(String departmentName);

    List<Department> getDepartmentContainString(String innerString);



}
