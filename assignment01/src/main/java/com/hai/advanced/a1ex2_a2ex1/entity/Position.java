package com.hai.advanced.a1ex2_a2ex1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private short id;

    public Position() {
    }

    public Position(PositionType positionType) {
        this.positionType = positionType;
    }

    public enum PositionType {
        DEV, TEST, SCRUM_MASTER, PM
    }

    @Column(name = "position_name")
    @Convert(converter = PositionTypeConverter.class)
    private PositionType positionType;

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", positionType=" + positionType.toString() +
                '}';
    }
}
