package com.hai.learning.finalexam01.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "accessories")
public class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "damage_status")
    private String damageStatus;

    @Column(name = "repair_status")
    private String repairStatus;

    @ManyToOne
}
