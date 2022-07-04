package com.hai.learning.assignment08current.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "department")
@Data
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "total_member")
    private int totalNumber;

    public enum DepartmentType{
        DEV, TEST, SCUM_MASTER, PM
    }

    @Column(name = "type")
    @Convert(converter = DepartmentTypeConverter.class)
    private DepartmentType type;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

}
