package com.hai.learning.assignment08.repository;

import com.hai.learning.assignment08.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface IDepartmentRepository extends JpaRepository<Department,Integer>, JpaSpecificationExecutor<Department> {
    Department getByName(String name);

    @Query(value = "SELECT * FROM department WHERE departmentName = ?1", nativeQuery = true)
    Department existByName(String name);
}
