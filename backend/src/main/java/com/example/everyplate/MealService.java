package com.example.everyplate;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    private final MealRepository mealRepository;
    private final MeasurementRepository measurementRepository;
    private final InstructionRepository instructionRepository;

    public MealService(MealRepository mealRepository, MeasurementRepository measurementRepository, InstructionRepository instructionRepository) {
        this.mealRepository = mealRepository;
        this.measurementRepository = measurementRepository;
        this.instructionRepository = instructionRepository;
    }

    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    public MealDetails getMealDetails(Long id) {
        Meal meal = mealRepository.findById(id).orElseThrow();
        List<IngMeasurementDTO> ingMeasurements = measurementRepository.findMealIngMeasurements(id);
        List<Instruction> instructions = instructionRepository.findAllByMealIdOrderByStepNumber(id);

        return new MealDetails(meal, ingMeasurements, instructions);
    }
}
