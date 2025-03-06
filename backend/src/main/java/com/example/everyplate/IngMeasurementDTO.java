package com.example.everyplate;

public class IngMeasurementDTO {
    private String name;
    private String measurement;

    public IngMeasurementDTO() { }

    public IngMeasurementDTO(String name, String measurement) {
        this.name = name;
        this.measurement = measurement;
    }

    public String getName() {
        return name;
    }

    public String getMeasurement() {
        return measurement;
    }
}
