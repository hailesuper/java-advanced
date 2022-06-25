package com.hai.learning.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
@PrimaryKeyJoinColumn(name = "accountID")
public class Employee extends Account {
    @Column(name = "workingNumberOfYear")
    private short workingNumberOfYear;

}
