package com.hai.learning.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionID")
    private short id;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "categoryID")
    private QuestionCategory questionCategory;

    @ManyToOne
    @JoinColumn(name = "typeID")
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "creatorID")
    private Account account;

    @Column(name = "createDate")
    @CreationTimestamp
    private LocalDate createDate;

    // Constructors
    public Question() {
    }

    public Question(String content, QuestionCategory questionCategory, QuestionType questionType, Account account) {
        this.content = content;
        this.questionCategory = questionCategory;
        this.questionType = questionType;
        this.account = account;
    }

    // Getters and Setters

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public QuestionCategory getQuestionCategory() {
        return questionCategory;
    }

    public void setQuestionCategory(QuestionCategory questionCategory) {
        this.questionCategory = questionCategory;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
