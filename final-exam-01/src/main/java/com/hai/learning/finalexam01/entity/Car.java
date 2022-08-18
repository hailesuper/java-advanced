package com.hai.learning.finalexam01.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cars")
public class Car {

    @EmbeddedId
    private CarPK id;

    @Column(name = "customer_name", nullable = false, length = 100)
    private String customerName;

    @Column(name = "catalogs")
    private String catalog;

    public enum CarMaker {
        HONDA, TOYOTA
    }

    @Column(name = "car_maker")
    @Convert(converter = CarMakerConverter.class)
    private CarMaker carMaker;

    @OneToMany
    @MapsId(name = "")

}
