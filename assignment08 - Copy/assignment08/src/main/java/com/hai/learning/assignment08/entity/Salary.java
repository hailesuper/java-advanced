package com.hai.learning.assignment08.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "answer")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
//
//    enum SalaryNameEnum {
//        600, 700
//    }
}
