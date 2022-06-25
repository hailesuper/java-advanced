package com.hai.learning.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "typeQuestion")
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "typeID")
    private short id;


//    @Column(name = "typeName")
//    private

}
