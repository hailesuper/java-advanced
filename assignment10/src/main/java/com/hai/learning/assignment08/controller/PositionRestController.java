package com.hai.learning.assignment08.controller;

import com.hai.learning.assignment08.dto.DepartmentDTO;
import com.hai.learning.assignment08.dto.PositionDTO;
import com.hai.learning.assignment08.entity.Department;
import com.hai.learning.assignment08.entity.Position;
import com.hai.learning.assignment08.form.DepartmentFilterForm;
import com.hai.learning.assignment08.form.DepartmentForm;
import com.hai.learning.assignment08.service.IDepartmentService;
import com.hai.learning.assignment08.service.IPositionService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/positions")
public class PositionRestController {
    @Autowired
    private IPositionService positionService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<Page<PositionDTO>> getAllPositions(Pageable pageable) {

        Page<Position> positionPage = positionService.getAllPositions(pageable);

        List<PositionDTO> positionFormList = modelMapper.map(
                positionPage.getContent(),
                new TypeToken<List<PositionDTO>>(){}.getType()
        );

        Page<PositionDTO> positionDTOPage = new PageImpl<>(positionFormList, pageable, positionPage.getTotalElements());
        return new ResponseEntity<>(positionDTOPage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PositionDTO> getPositionById(@PathVariable short id) {
        var position = positionService.getPositionById(id);
        var positionDTO = modelMapper.map(position, PositionDTO.class);
        return new ResponseEntity<>(positionDTO, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PositionDTO> getPositionByName(@PathVariable String name) {
        var position = positionService.getPositionByName(name);
        var positionDTO = modelMapper.map(position, PositionDTO.class);
        return new ResponseEntity<>(positionDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> createPosition(@RequestBody Position newPosition) {
        positionService.createPosition(newPosition);
        return new ResponseEntity<>(newPosition.toString() +
                "\nhas been created", HttpStatus.CREATED);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<String> updatePosition(@PathVariable short id, @RequestBody PositionForm positionForm) {
//        var tempPosition = positionForm.toEntity();
//        tempPosition.setId(id);
//        positionService.updatePosition(tempPosition);
//        return new ResponseEntity<>(positionService.getPositionById(id) +
//                "\nhas been updated", HttpStatus.OK);
//    }
//
//    @PutMapping()
//    public ResponseEntity<String> updatePosition(@RequestBody Position newPosition) {
//        try {
//            positionService.updatePosition(newPosition);
//            return new ResponseEntity<>(newPosition.toString() +
//                    "\nhas been updated", HttpStatus.OK);
//        }
//        catch (IllegalArgumentException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePosition(@PathVariable short id) {
        var tempPosition = positionService.getPositionById(id);
        positionService.deletePosition(id);
        return new ResponseEntity<>(tempPosition.toString() +
                "\n has been deleted", HttpStatus.OK);
    }

    @GetMapping("/check")
    public ResponseEntity<String> isPositionExistsByName(String name) {
        var flagExist = positionService.isPositionExistsByName(name);
        if (flagExist) {
            return new ResponseEntity<>(positionService.getPositionByName(name).toString() +
                    "\nexists", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(positionService.getPositionByName(name).toString() +
                    "\ndoesn't exists", HttpStatus.OK);
        }

    }

    @GetMapping("/check/{id}")
    public ResponseEntity<String> isPositionExistsById(@PathVariable short id) {
        var flagExist = positionService.isPositionExistsById(id);
        if (flagExist) {
            return new ResponseEntity<>(positionService.getPositionById(id).toString() +
                    "\nexists", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Position " + id +
                    "\ndoesn't exists", HttpStatus.OK);
        }

    }
}
