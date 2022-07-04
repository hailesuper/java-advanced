//package com.hai.learning.assignment08.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//
//@Entity
//@Table(name = "detailDepartment")
//@Data
//@RequiredArgsConstructor
//@NoArgsConstructor
//public class DepartmentDetail {
//    // Instance variables
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "departmentID")
//    private short id;
//
//    @ManyToOne
//    @Column(name = "addressID")
//    Address address;
//
//    @Column(name = "emulationPoint")
//    private short emulationPoint;
//
//}
