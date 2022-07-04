package com.hai.learning.assignment08.service;

import com.hai.learning.assignment08.entity.Department;
import com.hai.learning.assignment08.form.DepartmentFilterForm;
import com.hai.learning.assignment08.repository.IDepartmentRepository;
import com.hai.learning.assignment08.specification.DepartmentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository departmentRepository;

//
//
////    @Override    @Override
//    public Page<Department> getAllDepartments(Pageable pageable, String search) {
//        var where = DepartmentSpecification.buildWhere(search);
//        return departmentRepository.findAll(where, pageable);
//    }
    @Override
    public Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFilterForm departmentFilterForm) {
        var where = DepartmentSpecification.buildWhere(search, departmentFilterForm);
        return departmentRepository.findAll(where, pageable);
    }

    @Override
    public Department getDepartmentById(short id) {
        return departmentRepository.findById((int)id).get();
//        return  departmentRepository.getById((int) id);
//        return  departmentRepository.getReferenceById((int)id);
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.getByName(name);
    }

    @Override
    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void updateDepartment(short id, String newName) {
        var tempDepartment = getDepartmentById(id);
        tempDepartment.setName(newName);
        departmentRepository.save(tempDepartment);
    }

    @Override
    public void updateDepartment(Department department) {
        if (departmentRepository.existsById((int) department.getId())) {
            var oldDepartment = getDepartmentById((short) department.getId());
            if (department.getName() == null)
                department.setName(oldDepartment.getName());
            departmentRepository.save(department);
        }
        else
            throw new NoSuchElementException("Department " + department.getId() + " doesn't exists");
    }

    @Override
    public void deleteDepartment(short id) {
        departmentRepository.deleteById((int) id);
    }

    @Override
    public boolean isDepartmentExistsById(short id) {
        return departmentRepository.existsById((int) id);
    }

    @Override
    public boolean isDepartmentExistsByName(String name) {
        return departmentRepository.existByName(name) != null;
    }
}
