//package com.hai.learning.assignment08.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "question")
//@Data
//@RequiredArgsConstructor
//@NoArgsConstructor
//public class Question {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "questionID")
//    private short id;
//
//    @Column(name = "content")
//    private String content;
//
//    @ManyToOne
//    @JoinColumn(name = "categoryID")
//    private QuestionCategory questionCategory;
//
//    @ManyToOne
//    @JoinColumn(name = "typeID")
//    private QuestionType questionType;
//
//    @ManyToOne
//    @JoinColumn(name = "creatorID")
//    private Account account;
//
//    @Column(name = "createDate")
//    @CreationTimestamp
//    private LocalDate createDate;
//}
