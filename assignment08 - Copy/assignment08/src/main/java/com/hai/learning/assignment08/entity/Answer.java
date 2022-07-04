//package com.hai.learning.assignment08.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//
//@Entity
//@Table(name = "answer")
//@Data
//@RequiredArgsConstructor
//@NoArgsConstructor
//public class Answer {
//    // Instance variables
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "answers")
//    private short id;
//
//    @Column(name = "content", length = 100)
//    private String content;
//
//    @ManyToOne
//    @Column(name = "questionID")
//    Question question;
//
//    @Column(name = "isCorrect")
//    private boolean isCorrect;
//}
