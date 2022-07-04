package com.hai.learning.helloworldspringdata.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departmentID")
    private short departmentId;

    @Column(name = "totalMember")
    private short totalMember;

    @Column(name = "departmentName")
    private String departmentName;

    // Constructors

    public Department(short totalMember, String departmentName) {
        this.totalMember = totalMember;
        this.departmentName = departmentName;
    }

    public Department() {
    }

    // toString

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", totalMember=" + totalMember +
                ", departmentName='" + departmentName + '\'' +
                '}' + "\n";
    }


    // Getters and Setters

    public short getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(short departmentId) {
        this.departmentId = departmentId;
    }

    public short getTotalMember() {
        return totalMember;
    }

    public void setTotalMember(short totalMember) {
        this.totalMember = totalMember;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
