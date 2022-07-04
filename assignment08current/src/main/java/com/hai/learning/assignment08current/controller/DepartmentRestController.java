package com.hai.learning.assignment08current.controller;


import com.hai.learning.assignment08current.entity.Department;
import com.hai.learning.assignment08current.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentRestController {
    @Autowired
    private IDepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
}
