package com.hai.learning.assignment08.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "position")
@Data
@RequiredArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "positionID")
    private short id;

    @Column(name = "positionName")
    private String positionName;
}
