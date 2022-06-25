package com.hai.learning.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {
    // Instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answers")
    private short id;

    @Column(name = "content", length = 100)
    private String content;

    @ManyToOne
    @Column(name = "questionID")
    Question question;

    @Column(name = "isCorrect")
    private boolean isCorrect;

    // Constructors

    public Answer() {
    }

    public Answer(String content, Question question, boolean isCorrect) {
        this.content = content;
        this.question = question;
        this.isCorrect = isCorrect;
    }

    // toString

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", question=" + question +
                ", isCorrect=" + isCorrect +
                '}';
    }

    // Getters and Setters

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
