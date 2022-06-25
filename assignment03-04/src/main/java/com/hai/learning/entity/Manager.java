package com.hai.learning.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "manager")
@PrimaryKeyJoinColumn(name = "accountID")
public class Manager extends Account{
    @Column(name = "managementNumberOfYear")
    private short managementNumberOfYear;

    // Constructors

    public Manager() {
    }

    public Manager(String email, String firstName, String lastName, Department department, Position position, Salary salary, short managementNumberOfYear) {
        super(email, firstName, lastName, department, position, salary);
        this.managementNumberOfYear = managementNumberOfYear;
    }

    // Getters and Setters

    public short getManagementNumberOfYear() {
        return managementNumberOfYear;
    }

    public void setManagementNumberOfYear(short managementNumberOfYear) {
        this.managementNumberOfYear = managementNumberOfYear;
    }
}
