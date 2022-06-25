package com.hai.learning.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "examID")
    private short id;

    @Column(name = "code")
    private String code;

    @ManyToOne
    @JoinColumn(name = "categoryID")
    QuestionCategory questionCategory;

    @Column(name = "duration")
    private short duration;

    @ManyToOne
    @JoinColumn(name = "creatorID")
    Account account;

    @Column(name = "createDate")
    @CreationTimestamp
    LocalDate createDate;

    @ManyToMany
    @JoinTable(name = "examQuestion",
                joinColumns = @JoinColumn(name = "examID"),
                inverseJoinColumns = @JoinColumn(name = "questionID"))
    private List<Question> questions;
}
