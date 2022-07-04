package com.hai.learning.helloworldspringdata.controller;

import com.hai.learning.helloworldspringdata.entity.Department;
import com.hai.learning.helloworldspringdata.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentRestController {
    @Autowired
    private IDepartmentService departmentService;

//    @GetMapping("/departments")
//    public List<Department> getDepartments() {
//        return departmentService.getAllDepartments();
//    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getDepartments(Pageable pageable) {
        var departments = departmentService.getAllDepartments(pageable);
        return new ResponseEntity<>(departments, HttpStatus.CREATED);
    }



    @GetMapping("/departments/name/{name}")
    public List<Department> getByDepartmentName(@PathVariable String name) {
        return departmentService.getDepartmentContainString(name);
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
