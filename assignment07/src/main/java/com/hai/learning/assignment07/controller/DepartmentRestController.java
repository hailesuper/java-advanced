package com.hai.learning.assignment07.controller;

import com.hai.learning.assignment07.dto.DepartmentDTO;
import com.hai.learning.assignment07.entity.Department;
import com.hai.learning.assignment07.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentRestController {
    @Autowired
    IDepartmentService departmentService;

    @GetMapping()
    public ResponseEntity<Page<Department>> getAllDepartments(Pageable pageable) {
        Page<Department> departments = departmentService.getAllDepartments(pageable);
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable short id) {
        var department = departmentService.getDepartmentById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Department> getDepartmentByName(@PathVariable String name) {
        var department = departmentService.getDepartmentByName(name);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> createDepartment(@RequestBody Department newDepartment) {
        departmentService.createDepartment(newDepartment);
        return new ResponseEntity<>(newDepartment.toString() +
                "\nhas been created", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDepartment(@PathVariable short id, @RequestBody DepartmentDTO departmentDTO) {
        departmentDTO= new DepartmentDTO("abc");
        departmentService.updateDepartment(id, departmentDTO.toEntity().getName());
        return new ResponseEntity<>( departmentService.getDepartmentById(id) +
                "\nhas been updated", HttpStatus.OK);
//        Department department = departmentDTO.toEntity();
//        department.setId(id);
//        return new ResponseEntity<>(departmentDTO.toString(), HttpStatus.OK);

//        public ResponseEntity<String> updateDepartment(@PathVariable(name="id") short id, @RequestBody DepartmentDTO departmentDTO) {
//        departmentService.updateDepartment(id, departmentDTO.toEntity().getName());
//        return new ResponseEntity<>(getDepartmentById(id) +
//                "\nhas been updated", HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<String> updateDepartment(@RequestBody Department newDepartment) {
        try {
            departmentService.updateDepartment(newDepartment);
            return new ResponseEntity<>(newDepartment.toString() +
                    "\nhas been updated", HttpStatus.OK);
        }
        catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable short id) {
        var tempDepartment = departmentService.getDepartmentById(id);
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(tempDepartment.toString() +
                "\n has been deleted", HttpStatus.OK);
    }

    @GetMapping("/check")
    public ResponseEntity<String> isDepartmentExistsByName(String name) {
        var flagExist = departmentService.isDepartmentExistsByName(name);
        if (flagExist) {
            return new ResponseEntity<>(departmentService.getDepartmentByName(name).toString() +
                    "\nexists", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(departmentService.getDepartmentByName(name).toString() +
                    "\ndoesn't exists", HttpStatus.OK);
        }

    }

    @GetMapping("/check/{id}")
    public ResponseEntity<String> isDepartmentExistsById(@PathVariable short id) {
        var flagExist = departmentService.isDepartmentExistsById(id);
        if (flagExist) {
            return new ResponseEntity<>(departmentService.getDepartmentById(id).toString() +
                    "\nexists", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Department " + id +
                    "\ndoesn't exists", HttpStatus.OK);
        }

    }
}
