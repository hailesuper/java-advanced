package com.hai.advanced.a1ex2_a2ex1_a3ex2.entity;

import jakarta.persistence.*;

import java.util.List;

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
    @Convert(converter = PositionTypeConverter.class)
    private PositionType positionType;

    // CONSTRUCTOR

    public Position() {
    }

    public Position(PositionType positionType) {
        this.positionType = positionType;
    }

    // MAPPING
    @OneToMany(mappedBy = "position")
    private List<Account> accounts;


    public PositionType getPositionType() {
        return positionType;
    }

    // GETTERS AND SETTERS

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", positionType=" + positionType.toString() +
                '}';
    }
}
