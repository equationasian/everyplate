package com.example.everyplate;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MealModelAssembler implements RepresentationModelAssembler<Meal, EntityModel<Meal>> {
    @Override
    public EntityModel<Meal> toModel(Meal meal) {
        return EntityModel.of(meal,
                linkTo(methodOn(MealController.class).one(meal.getId())).withSelfRel(),
                linkTo(methodOn(MealController.class).all()).withRel("meals"));
    }
}
