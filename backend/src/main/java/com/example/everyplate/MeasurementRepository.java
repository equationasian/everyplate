package com.example.everyplate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    @Query("SELECT new com.example.everyplate.IngMeasurementDTO(i.name, measure.measurement) " +
            "FROM Ingredient i " +
            "JOIN Measurement measure " +
            "ON i.id = measure.ingredient.id " +
            "WHERE measure.meal.id = :id")
    List<IngMeasurementDTO> findMealIngMeasurements(@Param("id") Long id);
}
