package com.example.everyplate;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "meal_instruction")
public class Instruction {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;

    private int stepNumber;
    private String instruction;

    public Instruction() { }

    public Instruction(Meal meal, int stepNumber, String instruction) {
        this.meal = meal;
        this.stepNumber = stepNumber;
        this.instruction = instruction;
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

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instruction that = (Instruction) o;
        return stepNumber == that.stepNumber && Objects.equals(id, that.id) && Objects.equals(meal, that.meal) && Objects.equals(instruction, that.instruction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, meal, stepNumber, instruction);
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "id=" + id +
                ", meal=" + meal +
                ", stepNumber=" + stepNumber +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}
