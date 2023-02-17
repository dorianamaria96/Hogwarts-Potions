package com.codecool.hogwarts_potions.service;

import com.codecool.hogwarts_potions.controller.exception.PotionNotFound;
import com.codecool.hogwarts_potions.controller.exception.StudentNotFound;
import com.codecool.hogwarts_potions.model.*;
import com.codecool.hogwarts_potions.repository.IngredientRepository;
import com.codecool.hogwarts_potions.repository.PotionRepository;
import com.codecool.hogwarts_potions.repository.RecipeRepository;
import com.codecool.hogwarts_potions.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class PotionService {
    private final PotionRepository potionRepository;
    private final RecipeRepository recipeRepository;
    private final StudentRepository studentRepository;
    private final IngredientRepository ingredientRepository;

    public PotionService(PotionRepository potionRepository, RecipeRepository recipeRepository, StudentRepository studentRepository,
                         IngredientRepository ingredientRepository) {
        this.potionRepository = potionRepository;
        this.recipeRepository = recipeRepository;
        this.studentRepository = studentRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<Potion> getAllPotions() {
        return potionRepository.findAll();
    }

    public void brewPotion(Long potionId) throws StudentNotFound, PotionNotFound {
        List<Recipe> recipes = recipeRepository.findAll();
        Potion potion = potionRepository.findById(potionId).orElseThrow(()-> new PotionNotFound("There is no potion with this id."));
        for (Recipe recipe : recipes) {
            if (recipe.getIngredients().containsAll(potion.getIngredients()) && (potion.getIngredients()).containsAll(recipe.getIngredients())) {
                potion.setBrewingStatus(BrewingStatus.REPLICA);
            } else {
                potion.setBrewingStatus(BrewingStatus.DISCOVERY);
                Student student = studentRepository.findById(potion.getStudent().getId()).orElseThrow(() -> new StudentNotFound("No Student with this id."));
                potion.setName(student.getName() + " discovery #" + recipe.getId());
            }
            potionRepository.save(potion);
        }
    }

    public List<Potion> getStudentsPotions(Long studentId) throws StudentNotFound {
        Student student = studentRepository.findById(studentId).orElseThrow(()->new StudentNotFound("There is no student with this id."));
        return potionRepository.getPotionByStudent(student);
    }

    public boolean isIngredientPersisted(Ingredient ingredient) {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        return ingredients.contains(ingredient);
    }

    public Potion addIngredientToPotion(Long potionId, Ingredient ingredient) throws PotionNotFound, StudentNotFound {
        if (isIngredientPersisted(ingredient)) {
            ingredientRepository.save(ingredient);
        }
        Potion potion = potionRepository.findById(potionId).orElseThrow(()-> new PotionNotFound("There is no potion with this id."));
        Set<Ingredient> ingredients = potion.getIngredients();
        ingredients.add(ingredient);
        potion.setIngredients(ingredients);
        if (ingredients.size() >= 5 ) {
            brewPotion(potionId);
        }
        return potionRepository.save(potion);
    }

    public List<Recipe> getRecipesForPotion(Long potionId) throws PotionNotFound {
        List<Recipe> existingRecipes = recipeRepository.findAll();
        List<Recipe> recipesContainingPotionsIngredients = null;
        Potion potion = potionRepository.findById(potionId).orElseThrow(()-> new PotionNotFound("There is no potion with this id."));
        Set<Ingredient> potionsRecipe = potion.getIngredients();
        for (Recipe existingRecipe : existingRecipes) {
            if (potionsRecipe.containsAll(existingRecipe.getIngredients()) && (existingRecipe.getIngredients()).containsAll(potionsRecipe)) {
                recipesContainingPotionsIngredients.add(existingRecipe);
            }
        }
        return recipesContainingPotionsIngredients;
    }
}
