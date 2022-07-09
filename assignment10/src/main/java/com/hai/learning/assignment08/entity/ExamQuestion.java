package com.hai.learning.assignment08.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "answer")
public class ExamQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

}
