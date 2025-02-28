package com.example.everyplate;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class MealController {
    private final MealRepository mealRepository;
    private final MealModelAssembler assembler;

    public MealController(MealRepository mealRepository, MealModelAssembler assembler) {
        this.mealRepository = mealRepository;
        this.assembler = assembler;
    }

    @GetMapping("/meals")
    public CollectionModel<EntityModel<Meal>> all() {
        List<EntityModel<Meal>> meals = mealRepository.findAll().stream()
                .map(assembler::toModel)
                .toList();

        return CollectionModel.of(meals, linkTo(methodOn(MealController.class).all()).withSelfRel());
    }

    @GetMapping("/meals/{id}")
    public EntityModel<Meal> one(@PathVariable Long id) {
        Meal meal = mealRepository.findById(id).orElseThrow();
        return assembler.toModel(meal);
    }
}