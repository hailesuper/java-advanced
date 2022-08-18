package com.hai.learning.assignment08.repository;

import com.hai.learning.assignment08.entity.Salary;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface ISalaryRepository extends JpaRepository<Salary,Integer>, JpaSpecificationExecutor<Salary> {
    Salary getByName(String name);

    @Query(value = "SELECT * FROM salary WHERE salaryName = ?1", nativeQuery = true)
    Salary existByName(String name);
}
