package com.example.everyplate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MealRepository extends JpaRepository<Meal, Long> {
    /*@Query("SELECT i.name, measure.measurement " +
            "FROM Ingredient i " +
            "JOIN Measurement measure " +
            "ON i.id = measure.ingredient.id " +
            "WHERE measure.meal.id = :id")
    MealIngMeasurement findMealIngMeasurements(@Param("id") Long id);*/

    Meal findByName(String name);
}
