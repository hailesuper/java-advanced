package com.hai.learning.assignment08.service;

import com.hai.learning.assignment08.entity.Department;
import com.hai.learning.assignment08.entity.Position;
import com.hai.learning.assignment08.form.DepartmentFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPositionService {
    Page<Position> getAllPositions(Pageable pageable);


    Position getPositionById(short id);
    Position getPositionByName(String name);
    void createPosition(Position position);
//    void updatePosition(short id, String newName);
//    void updatePosition(Position position);
    void deletePosition(short id);
    boolean isPositionExistsById(short id);
    boolean isPositionExistsByName(String name);
}
