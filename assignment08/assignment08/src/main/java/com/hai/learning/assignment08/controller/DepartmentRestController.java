package com.hai.learning.assignment08.controller;

import com.hai.learning.assignment08.dto.DepartmentDTO;
import com.hai.learning.assignment08.form.DepartmentFilterForm;
import com.hai.learning.assignment08.form.DepartmentForm;
import com.hai.learning.assignment08.entity.Department;
import com.hai.learning.assignment08.service.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentRestController {
    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private ModelMapper modelMapper;

//    @GetMapping()
////    public ResponseEntity<Page<Department>> getAllDepartments(Pageable pageable) {
////        Page<Department> departments = departmentService.getAllDepartments(pageable);
////        return new ResponseEntity<>(departments, HttpStatus.OK);
////    }

//    @GetMapping()
//    public ResponseEntity<Page<DepartmentDTO>> getAllDepartments(
//            Pageable pageable,
//            @RequestParam(required = false) String search) {
//        Page<Department> departmentPage = departmentService.getAllDepartments(pageable, search);
//
//        List<DepartmentDTO> departmentFormList = modelMapper.map(
//                departmentPage.getContent(),
//                new TypeToken<List<DepartmentDTO>>(){}.getType()
//        );
//
//        Page<DepartmentDTO> departmentDTOPage = new PageImpl<>(departmentFormList, pageable, departmentPage.getTotalElements());
//        return new ResponseEntity<>(departmentDTOPage, HttpStatus.OK);
//    }

    @GetMapping()
    public ResponseEntity<Page<DepartmentDTO>> getAllDepartments(
            Pageable pageable,
            @RequestParam(required = false) String search,
            DepartmentFilterForm departmentFilterForm) {

        Page<Department> departmentPage = departmentService.getAllDepartments(pageable, search, departmentFilterForm);

        List<DepartmentDTO> departmentFormList = modelMapper.map(
                departmentPage.getContent(),
                new TypeToken<List<DepartmentDTO>>(){}.getType()
        );

        Page<DepartmentDTO> departmentDTOPage = new PageImpl<>(departmentFormList, pageable, departmentPage.getTotalElements());
        return new ResponseEntity<>(departmentDTOPage, HttpStatus.OK);
//        return new ResponseEntity<>(minID.toString() + maxID.toString(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable short id) {
        var department = departmentService.getDepartmentById(id);
        var departmentDTO = modelMapper.map(department, DepartmentDTO.class);
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<DepartmentDTO> getDepartmentByName(@PathVariable String name) {
        var department = departmentService.getDepartmentByName(name);
        var departmentDTO = modelMapper.map(department, DepartmentDTO.class);
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> createDepartment(@RequestBody Department newDepartment) {
        departmentService.createDepartment(newDepartment);
        return new ResponseEntity<>(newDepartment.toString() +
                "\nhas been created", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDepartment(@PathVariable short id, @RequestBody DepartmentForm departmentForm) {
        var tempDepartment = departmentForm.toEntity();
        tempDepartment.setId(id);
        departmentService.updateDepartment(tempDepartment);
        return new ResponseEntity<>(departmentService.getDepartmentById(id) +
                "\nhas been updated", HttpStatus.OK);
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
