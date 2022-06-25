package com.hai.learning.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categoryQuestion")
public class QuestionCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryID")
    private short id;

    @Column(name = "categoryName")
    private String categoryName;

    // Constructors

    public QuestionCategory(short id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public QuestionCategory() {
    }

    // Getters and Setters

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
