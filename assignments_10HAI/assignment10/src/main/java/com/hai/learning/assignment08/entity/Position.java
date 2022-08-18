package com.hai.learning.assignment08.entity;

import com.hai.learning.assignment08.enumconverter.PositionNameConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "position")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "positionID")
    private short id;

    public enum PositionName{
        DEV, TEST, SCUM_MASTER, PM
    }

    @NonNull
    @Column(name = "positionName")
    @Convert(converter = PositionNameConverter.class)
    private PositionName name;

    @OneToMany(mappedBy = "position")
    private List<Account> accounts;

}
