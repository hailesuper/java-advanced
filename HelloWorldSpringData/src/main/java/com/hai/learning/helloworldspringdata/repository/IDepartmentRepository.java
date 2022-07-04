package com.hai.learning.helloworldspringdata.repository;

import com.hai.learning.helloworldspringdata.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
    Department getByDepartmentName(String departmentName);

//    @Query(value = "SELECT * FROM department WHERE departmentName LIKE %:nameParam%", nativeQuery = true)
    @Query("FROM Department d WHERE d.departmentName LIKE %:nameParam%")
    List<Department> getDepartmentContainString(@Param("nameParam") String innerString);
}
