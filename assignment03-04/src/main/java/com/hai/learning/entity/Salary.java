package com.hai.learning.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "answer")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

}
