package com.hai.learning.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "positionID")
    private short id;

    @Column(name = "positionName")
    private String positionName;

    // Constructors
    public Position(String positionName) {
        this.positionName = positionName;
    }

    public Position() {
    }

    // Getters and Setters

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
