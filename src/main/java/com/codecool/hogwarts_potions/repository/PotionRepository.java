package com.codecool.hogwarts_potions.repository;

import com.codecool.hogwarts_potions.model.Potion;
import com.codecool.hogwarts_potions.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PotionRepository extends JpaRepository<Potion, Long> {
    List<Potion> getPotionByStudent (Student student);
}
