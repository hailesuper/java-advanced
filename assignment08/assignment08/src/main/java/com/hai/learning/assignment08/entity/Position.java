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

    public enum PositionName{
        DEV, TEST, SCUM_MASTER, PM
    }

    @Column(name = "positionName")
    @Convert(converter = )
    private PositionName positionName;

}
