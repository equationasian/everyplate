package com.example.everyplate;

import java.util.List;

public class MealDetails {
    private Meal meal;
    private List<IngMeasurementDTO> ingMeasurements;
    private List<Instruction> instructions;

    public MealDetails() { }

    public MealDetails(Meal meal, List<IngMeasurementDTO> ingMeasurements, List<Instruction> instructions) {
        this.meal = meal;
        this.ingMeasurements = ingMeasurements;
        this.instructions = instructions;
    }

    public Meal getMeal() {
        return meal;
    }

    public List<IngMeasurementDTO> getIngMeasurements() {
        return ingMeasurements;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }
}