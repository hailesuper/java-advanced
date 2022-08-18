package com.hai.learning.assignment08.service;

import com.hai.learning.assignment08.entity.Position;
import com.hai.learning.assignment08.entity.Salary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface ISalaryService {
    Page<Salary> getAllSalaries(Pageable pageable);


    Salary getSalaryById(short id);
    Salary getSalaryByName(String name);
    void createSalary(Salary salary);
    //    void updateSalary(short id, String newName);
//    void updateSalary(Salary salary);
    void deleteSalary(short id);
    boolean isSalaryExistsById(short id);
    boolean isSalaryExistsByName(String name);
}
