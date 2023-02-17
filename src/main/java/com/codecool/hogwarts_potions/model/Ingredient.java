package com.codecool.hogwarts_potions.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Ingredient {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Ingredient(String name) {
        this.name = name;
    }
}
