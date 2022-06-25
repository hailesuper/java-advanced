package com.hai.learning.assignment06.controller;

import com.hai.learning.assignment06.entity.Department;
import com.hai.learning.assignment06.repository.IDepartmentRepository;
import com.hai.learning.assignment06.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentRestController {
    @Autowired
    private IDepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        return departmentService.getAllDepartments();
    }
//
//    @GetMapping("/departmentSearch")
//    public List<Department> getDepartmentsWithCriteria(
//            @RequestParam(defaultValue = "1") int pageNumber,
//            @RequestParam(defaultValue = "5") int pageSize,
//            @RequestParam(defaultValue = "") String departmentNameSearch,
//            @RequestParam(defaultValue = "departmentId") String sortBy,
//            @RequestParam(defaultValue = "asc") String sortType
//    ) {
//        return departmentService.getDepartmentsWithCriteria(pageNumber, pageSize, departmentNameSearch, sortBy, sortType);
//    }
//
////     Test getDepartmentById using @RequestParam
//    @GetMapping("/department/{id}")
//    public Department getDepartmentById(@PathVariable("id") int id) {
//        return departmentService.getDepartmentById(id);
//    }
//


//    @GetMapping("/departmentsNew")
//    public List<Department> getDepartmentsWithCriteria() {
//        return departmentService.getDepartmentsWithCriteria();
//    }



//    filter, paging, sort
}
