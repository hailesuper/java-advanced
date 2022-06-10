package com.hai.advanced.a1ex2_a2ex1_a3ex2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "question_categories")
public class QuestionCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private short id;

    @Column(name = "category_name", length = 20, nullable = false)
    private String categoryName;

    // CONSTRUCTORS
    public QuestionCategory() {
    }

    public QuestionCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    // GETTERS AND SETTERS

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
