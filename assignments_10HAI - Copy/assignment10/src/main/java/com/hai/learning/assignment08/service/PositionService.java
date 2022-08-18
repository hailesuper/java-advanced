package com.hai.learning.assignment08.service;

import com.hai.learning.assignment08.entity.Department;
import com.hai.learning.assignment08.entity.Position;
import com.hai.learning.assignment08.form.DepartmentFilterForm;
import com.hai.learning.assignment08.repository.IDepartmentRepository;
import com.hai.learning.assignment08.repository.IPositionRepository;
import com.hai.learning.assignment08.specification.DepartmentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.NoSuchElementException;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public Page<Position> getAllPositions(Pageable pageable) {
        return positionRepository.findAll(pageable);
    }

    @Override
    public Position getPositionById(short id) {
        return positionRepository.findById((int)id).get();
    }

    @Override
    public Position getPositionByName(String name) {
        return positionRepository.getByName(name);
    }

    @Override
    public void createPosition(Position position) {
        positionRepository.save(position);
    }

//    @Override
//    public void updatePosition(short id, String newName) {
//        var tempPosition = getPositionById(id);
//        tempPosition.setName(newName);
//        positionRepository.save(tempPosition);
//    }
//
//    @Override
//    public void updatePosition(Position position) {
//        if (positionRepository.existsById(position.getId())) {
//            var oldPosition = getPositionById((short) position.getId());
//            if (ObjectUtils.isEmpty(position.getName()))
//                position.setName(oldPosition.getName());
//            if (ObjectUtils.isEmpty(position.getAccounts()))
//                position.setAccounts(oldPosition.getAccounts());
//            positionRepository.save(position);
//        }
//        else
//            throw new NoSuchElementException("Position " + position.getId() + " doesn't exists");
//    }

    @Override
    public void deletePosition(short id) {
        positionRepository.deleteById((int) id);
    }

    @Override
    public boolean isPositionExistsById(short id) {
        return positionRepository.existsById((int) id);
    }

    @Override
    public boolean isPositionExistsByName(String name) {
        return positionRepository.existByName(name) != null;
    }
}
