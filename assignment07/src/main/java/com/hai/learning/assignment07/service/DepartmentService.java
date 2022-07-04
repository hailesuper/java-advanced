package com.hai.learning.assignment07.service;

import com.hai.learning.assignment07.entity.Department;
import com.hai.learning.assignment07.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    IDepartmentRepository departmentRepository;

    @Override
    public Page<Department> getAllDepartments(Pageable pageable) {
        return departmentRepository.findAll(pageable);
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
        if (departmentRepository.existsById(department.getId())) {
            var oldDepartment = getDepartmentById((short) department.getId());
            if (department.getName() == null)
                department.setName(oldDepartment.getName());
            if (department.getTotalMember() == null) {
                department.setTotalMember(oldDepartment.getTotalMember());
            }
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
