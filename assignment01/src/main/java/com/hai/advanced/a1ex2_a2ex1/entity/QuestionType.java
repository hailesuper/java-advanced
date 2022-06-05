package com.hai.advanced.a1ex2_a2ex1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "question_types")
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private short id;

    public enum QuestionTypeName {ESSAY, MULTIPLE_CHOICE};

    @Column(name = "type_name", nullable = false)
    @Convert(converter = QuestionTypeNameConverter.class)
    private QuestionTypeName typeName;

    // CONSTRUCTORS

    public QuestionType(QuestionTypeName typeName) {
        this.typeName = typeName;
    }

    public QuestionType() {
    }

    // GETTERS AND SETTERS

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public QuestionTypeName getTypeName() {
        return typeName;
    }

    public void setTypeName(QuestionTypeName typeName) {
        this.typeName = typeName;
    }

    // toString

    @Override
    public String toString() {
        return "QuestionType{" +
                "id=" + id +
                ", typeName=" + typeName +
                '}' + "\n";
    }
}
