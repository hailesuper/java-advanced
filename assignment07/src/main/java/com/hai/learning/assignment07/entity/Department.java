package com.hai.learning.assignment07.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "department")
@NoArgsConstructor

@RequiredArgsConstructor
@Data
public class Department {
    @Id
    @Column(name = "departmentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "totalMember")
    private Integer totalMember;

    @Column(name = "departmentName", length = 30, nullable = false)
    @NonNull
    private String name;

//    public Department(@NonNull String name) {
//        this.name = name;
//    }
}
