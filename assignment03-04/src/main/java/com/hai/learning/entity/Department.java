package com.hai.learning.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class Department {
    // Instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departmentID")
    private short id;

    @Column(name = "departmentName")
    private String departmentName;

    // Constructors
    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    // toString
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    // Getters and Setters
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
