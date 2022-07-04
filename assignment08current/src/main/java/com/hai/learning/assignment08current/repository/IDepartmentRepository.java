package com.hai.learning.assignment08current.repository;

import com.hai.learning.assignment08current.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department,Integer> {
}
