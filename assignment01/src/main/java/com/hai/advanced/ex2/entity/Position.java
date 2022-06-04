package com.hai.advanced.ex2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private short id;

    public enum PositionType {
        DEV, TEST, SCRUM_MASTER, PM
    }

    @Column(name = "position_name")
    private PositionType positionType;
}
