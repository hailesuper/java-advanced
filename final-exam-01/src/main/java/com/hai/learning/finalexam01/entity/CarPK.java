package com.hai.learning.finalexam01.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Data
@Table(name = "cars")
public class CarPK implements Serializable {
    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "repair_date")
    private LocalDate repairDate;
}
