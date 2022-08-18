package com.hai.learning.assignment08.controller;

import com.hai.learning.assignment08.dto.PositionDTO;
import com.hai.learning.assignment08.dto.SalaryDTO;
import com.hai.learning.assignment08.entity.Position;
import com.hai.learning.assignment08.entity.Salary;
import com.hai.learning.assignment08.service.IPositionService;
import com.hai.learning.assignment08.service.ISalaryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salaries")
public class SalaryRestController {
    @Autowired
    private ISalaryService salaryService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<Page<SalaryDTO>> getAllSalaries(Pageable pageable) {

        Page<Salary> salaryPage = salaryService.getAllSalaries(pageable);

        List<SalaryDTO> salaryFormList = modelMapper.map(
                salaryPage.getContent(),
                new TypeToken<List<SalaryDTO>>(){}.getType()
        );

        Page<SalaryDTO> salaryDTOPage = new PageImpl<>(salaryFormList, pageable, salaryPage.getTotalElements());
        return new ResponseEntity<>(salaryDTOPage, HttpStatus.OK);
    }
}
