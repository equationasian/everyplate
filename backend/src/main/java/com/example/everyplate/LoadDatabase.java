package com.example.everyplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    public CommandLineRunner initDatabase(MealRepository mealRepository, IngredientRepository ingredientRepository, MeasurementRepository measurementRepository, InstructionRepository instructionRepository) {
        return args -> {
          Meal meal = new Meal("Sweet Soy-Glazed Meatballs with Roasted Broccoli & Carrots", 610, 5, 40);
          log.info("Preloaded: " + mealRepository.save(meal));

          Set<Ingredient> ingredientSet = new HashSet<>();
          ingredientSet.add(new Ingredient("Carrots", true));
          ingredientSet.add(new Ingredient("Broccoli", true));
          ingredientSet.add(new Ingredient("Garlic", false));
          ingredientSet.add(new Ingredient("Sweet Soy Glaze", false));
          ingredientSet.add(new Ingredient("Ground Beef", true));
          ingredientSet.add(new Ingredient("Panko Breadcrumbs", false));
          ingredientSet.add(new Ingredient("Kosher Salt", false));
          ingredientSet.add(new Ingredient("Black Pepper", false));
          ingredientSet.add(new Ingredient("Cooking Oil", false));
          ingredientRepository.saveAll(ingredientSet);
          ingredientSet.forEach(ing -> log.info("Preloaded: " + ing));

          Meal found = mealRepository.findByName(meal.getName());
          Set<Measurement> measurementSet = new HashSet<>();
          measurementSet.add(new Measurement(found, ingredientRepository.findByName("Carrots"), "9 oz"));
          measurementSet.add(new Measurement(found, ingredientRepository.findByName("Broccoli"), "1"));
          measurementSet.add(new Measurement(found, ingredientRepository.findByName("Garlic"), "2 Clove(s)"));
          measurementSet.add(new Measurement(found, ingredientRepository.findByName("Sweet Soy Glaze"), "4 TBSP"));
          measurementSet.add(new Measurement(found, ingredientRepository.findByName("Ground Beef"), "10 oz"));
          measurementSet.add(new Measurement(found, ingredientRepository.findByName("Panko Breadcrumbs"), "1/2 Cup(s)"));
          measurementSet.add(new Measurement(found, ingredientRepository.findByName("Kosher Salt"), "Varies"));
          measurementSet.add(new Measurement(found, ingredientRepository.findByName("Black Pepper"), "Varies"));
          measurementSet.add(new Measurement(found, ingredientRepository.findByName("Cooking Oil"), "Varies"));
          measurementRepository.saveAll(measurementSet);
          measurementSet.forEach(measurement -> log.info("Preloaded: " + measurement));

          Set<Instruction> instructionSet = new HashSet<>();
          instructionSet.add(new Instruction(found, 1, "Adjust rack to middle position and preheat oven to 425 degrees."));
          instructionSet.add(new Instruction(found, 2, "On one side of a baking sheet, toss carrots with a drizzle of oil, salt, and pepper."));
          instructionSet.add(new Instruction(found, 3, "Meanwhile, in a large bowl, toss broccoli with a drizzle of oil, salt, and pepper."));
          instructionSet.add(new Instruction(found, 4, "Once carrots have roasted 5 minutes, remove sheet from oven and carefully push carrots to one side."));
          instructionSet.add(new Instruction(found, 5, "Place half the sweet soy glaze in a small bowl."));
          instructionSet.add(new Instruction(found, 6, "Divide meatballs, carrots, and broccoli between plates."));
          instructionRepository.saveAll(instructionSet);
          instructionSet.forEach(instruction -> log.info("Preloaded: " + instruction));
        };
    }
}
