package com.codecool.hogwarts_potions.data_sample;

import com.codecool.hogwarts_potions.model.*;
import com.codecool.hogwarts_potions.repository.IngredientRepository;
import com.codecool.hogwarts_potions.repository.PotionRepository;
import com.codecool.hogwarts_potions.repository.RecipeRepository;
import com.codecool.hogwarts_potions.repository.StudentRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    ApplicationRunner runner(PotionRepository potionRepository,
                             StudentRepository studentRepository,
                             RecipeRepository recipeRepository,
                             IngredientRepository ingredientRepository) {
        return args -> {
            Ingredient salt = new Ingredient("Salt");
            Ingredient pepper = new Ingredient("Pepper");
            Ingredient vinegar = new Ingredient("Vinegar");
            ingredientRepository.save(salt);
            ingredientRepository.save(pepper);
            ingredientRepository.save(vinegar);

            Student hermioneGranger = new Student("Hermione Granger", HouseType.GRYFFINDOR, PetType.OWL);
            Student dracoMalfoy = new Student("Draco Malfoy", HouseType.RAVENCLAW, PetType.CAT);
            Student harryPotter = new Student("Harry Potter", HouseType.HUFFLEPUFF, PetType.NONE);
            Student nevilleLongbottom = new Student("Neville Longbottom", HouseType.SLYTHERIN, PetType.RAT);
            studentRepository.save(hermioneGranger);
            studentRepository.save(dracoMalfoy);
            studentRepository.save(harryPotter);
            studentRepository.save(nevilleLongbottom);

            Recipe juice = new Recipe("Juice", hermioneGranger, Set.of(salt, pepper, vinegar));
            recipeRepository.save(juice);

            Potion juiceReplica = new Potion("Juice Replica", dracoMalfoy, Set.of(salt, pepper, vinegar));
            Potion juiceNonReplica = new Potion("Juice NonReplica", dracoMalfoy, Set.of(pepper, vinegar));
            potionRepository.save(juiceReplica);
            potionRepository.save(juiceNonReplica);
        };
    }
}
