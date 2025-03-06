package com.example.everyplate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class MealController {
    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/meals")
    public ResponseEntity<List<Meal>> all() {
        return ResponseEntity.ok(mealService.getAllMeals());
    }

    @GetMapping("/meals/{id}")
    public ResponseEntity<MealDetails> one(@PathVariable Long id) {
        return ResponseEntity.ok(mealService.getMealDetails(id));
    }
}