package com.hai.learning.assignment06spring2;

import com.hai.learning.assignment06spring2.repository.DepartmentRepository;

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
