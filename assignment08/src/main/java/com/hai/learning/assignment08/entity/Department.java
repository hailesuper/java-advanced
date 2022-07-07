package com.hai.learning.assignment08.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "department")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departmentID")
    private int id;

    @Column(name = "departmentName")
    @NonNull
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Account> accounts;
}
