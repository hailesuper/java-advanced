package com.hai.learning.assignment08.service;

import com.hai.learning.assignment08.entity.Salary;
import com.hai.learning.assignment08.repository.ISalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SalaryService implements ISalaryService {
    @Autowired
    private ISalaryRepository salaryRepository;

    @Override
    public Page<Salary> getAllSalaries(Pageable pageable) {
        return salaryRepository.findAll(pageable);
    }

    @Override
    public Salary getSalaryById(short id) {
        return salaryRepository.findById((int)id).get();
    }

    @Override
    public Salary getSalaryByName(String name) {
        return salaryRepository.getByName(name);
    }

    @Override
    public void createSalary(Salary salary) {
        salaryRepository.save(salary);
    }

//    @Override
//    public void updateSalary(short id, String newName) {
//        var tempSalary = getSalaryById(id);
//        tempSalary.setName(newName);
//        salaryRepository.save(tempSalary);
//    }
//
//    @Override
//    public void updateSalary(Salary salary) {
//        if (salaryRepository.existsById(salary.getId())) {
//            var oldSalary = getSalaryById((short) salary.getId());
//            if (ObjectUtils.isEmpty(salary.getName()))
//                salary.setName(oldSalary.getName());
//            if (ObjectUtils.isEmpty(salary.getAccounts()))
//                salary.setAccounts(oldSalary.getAccounts());
//            salaryRepository.save(salary);
//        }
//        else
//            throw new NoSuchElementException("Salary " + salary.getId() + " doesn't exists");
//    }

    @Override
    public void deleteSalary(short id) {
        salaryRepository.deleteById((int) id);
    }

    @Override
    public boolean isSalaryExistsById(short id) {
        return salaryRepository.existsById((int) id);
    }

    @Override
    public boolean isSalaryExistsByName(String name) {
        return salaryRepository.existByName(name) != null;
    }
}
