package com.hai.learning.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detailDepartment")
public class DepartmentDetail {
    // Instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departmentID")
    private short id;

    @ManyToOne
    @Column(name = "addressID")
    Address address;

    @Column(name = "emulationPoint")
    private short emulationPoint;

    // Constructor

    public DepartmentDetail(Address address, short emulationPoint) {
        this.address = address;
        this.emulationPoint = emulationPoint;
    }

    public DepartmentDetail() {
    }

    // toString

    @Override
    public String toString() {
        return "DepartmentDetail{" +
                "id=" + id +
                ", address=" + address +
                ", emulationPoint=" + emulationPoint +
                '}';
    }


    // Getters and Setters

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public short getEmulationPoint() {
        return emulationPoint;
    }

    public void setEmulationPoint(short emulationPoint) {
        this.emulationPoint = emulationPoint;
    }
}
