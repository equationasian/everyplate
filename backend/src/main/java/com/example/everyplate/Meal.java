package com.example.everyplate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Meal {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int calories;
    private int prepMins;
    private int cookMins;

    public Meal () { }

    public Meal(String name, int calories, int prepMins, int cookMins) {
        this.name = name;
        this.calories = calories;
        this.prepMins = prepMins;
        this.cookMins = cookMins;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getPrepMins() {
        return prepMins;
    }

    public void setPrepMins(int prepMins) {
        this.prepMins = prepMins;
    }

    public int getCookMins() {
        return cookMins;
    }

    public void setCookMins(int cookMins) {
        this.cookMins = cookMins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return calories == meal.calories && prepMins == meal.prepMins && cookMins == meal.cookMins && Objects.equals(id, meal.id) && Objects.equals(name, meal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, calories, prepMins, cookMins);
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", prepMins=" + prepMins +
                ", cookMins=" + cookMins +
                '}';
    }
}