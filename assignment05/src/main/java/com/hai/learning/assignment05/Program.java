package com.hai.learning.assignment05;

import com.hai.learning.assignment05.repository.DepartmentRepository;
import com.hai.learning.assignment05.repository.IDepartmentRepository;

public class Program {
    public static void main(String[] args) {
        IDepartmentRepository departmentRepository = new DepartmentRepository();

        System.out.println(departmentRepository.getAllDepartments());
    }
}
