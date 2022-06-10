package com.hai.advanced.a1ex2_a2ex1_a3ex2.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "exam_id")
    private short id;

    @Column(name = "exam_code", length = 10, nullable = false)
    private String examCode;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

//    private QuestionCategory category;

    @Column(name = "duration", nullable = false)
    private short duration;

//    private Account creator;

    @Column(name = "create_date")
    @CreationTimestamp
    private LocalDate createDate;

    // CONSTRUCTORS
    public Exam() {
    }

    public Exam(String examCode, String title, short duration) {
        this.examCode = examCode;
        this.title = title;
        this.duration = duration;
    }

    // GETTERS AND SETTERS

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
