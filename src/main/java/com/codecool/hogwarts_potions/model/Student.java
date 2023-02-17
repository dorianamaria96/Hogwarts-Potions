package com.codecool.hogwarts_potions.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private HouseType houseType;
    private PetType petType;

    public Student(String name, HouseType houseType, PetType petType) {
        this.name = name;
        this.houseType = houseType;
        this.petType = petType;
    }
}
