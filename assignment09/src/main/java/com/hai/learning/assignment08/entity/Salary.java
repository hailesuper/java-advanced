//package com.hai.learning.assignment08.entity;
//
//import com.hai.learning.assignment08.enumconverter.SalaryNameConverter;
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//
//@Entity
//@Table(name = "salary")
//@Data
//@RequiredArgsConstructor
//@NoArgsConstructor
//public class Salary {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private short id;
//
//    public enum SalaryName {
//        DEV_SALARY, TEST_SALARY, SCRUM_MASTER_SALARY, PM_SALARY;
//        // 600: Dev, Test: 700, Scrum Master: 1500, PM: 2000
//
//    }
//
//    @NonNull
//    @Column(name = "salaryName")
//    @Convert(converter = SalaryNameConverter.class)
//    private SalaryName name;
//}
