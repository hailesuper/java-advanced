package com.hai.learning.assignment06;

import com.hai.learning.assignment06.repository.DepartmentRepository;
import com.hai.learning.assignment06.service.DepartmentService;

public class Program {
    public static void main(String[] args) {
        DepartmentRepository departmentRepository = new DepartmentRepository();
//        System.out.println(
//                departmentRepository.getDepartmentsWithCriteria(
//                        2,3,"","departmentId","asc"));

        // Test getDepartmentById
//        System.out.println(departmentRepository.getDepartmentById(1));
        System.out.println(departmentRepository.getAllDepartments());
    }
}
