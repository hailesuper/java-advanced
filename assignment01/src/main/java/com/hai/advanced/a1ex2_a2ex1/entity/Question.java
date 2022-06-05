package com.hai.advanced.a1ex2_a2ex1.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int id;

    @Column(name = "content", length = 1000, nullable = false)
    private String content;

//    private QuestionCategory questionCategory;
//
//    private QuestionType questionType;
//
//    private Account creator;

    @Column(name = "create_date")
    @CreationTimestamp
    private LocalDate createDate;
}
