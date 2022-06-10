package com.hai.advanced.a1ex2_a2ex1_a3ex2.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private short id;

    @Column(name = "department_name", length = 50, unique = true)
    private String departmentName;

    @OneToMany(mappedBy = "department", cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private List<Account> accounts;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    // CONSTRUCTORS
    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    // GETTERS AND SETTERS

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

    public List<Account> getAccounts() {
        return accounts;
    }
}
