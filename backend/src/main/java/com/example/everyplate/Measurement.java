package com.example.everyplate;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ingredient_measurement")
public class Measurement {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    private String measurement;

    public Measurement() { }

    public Measurement(Meal meal, Ingredient ingredient, String measurement) {
        this.meal = meal;
        this.ingredient = ingredient;
        this.measurement = measurement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement that = (Measurement) o;
        return Objects.equals(id, that.id) && Objects.equals(meal, that.meal) && Objects.equals(ingredient, that.ingredient) && Objects.equals(measurement, that.measurement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, meal, ingredient, measurement);
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", meal=" + meal +
                ", ingredient=" + ingredient +
                ", measurement='" + measurement + '\'' +
                '}';
    }
}
