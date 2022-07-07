package com.hai.learning.assignment08.repository;

import com.hai.learning.assignment08.entity.Department;
import com.hai.learning.assignment08.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface IPositionRepository extends JpaRepository<Position,Integer>, JpaSpecificationExecutor<Department> {
    Position getByName(String name);

    @Query(value = "SELECT * FROM position WHERE positionName = ?1", nativeQuery = true)
    Position existByName(String name);
}
