import { IngMeasurement } from "./IngMeasurement";
import { Instruction } from "./Instruction";
import { Meal } from "./Meal";

export interface MealDetails {
    meal: Meal,
    ingMeasurements: IngMeasurement[],
    instructions: Instruction[],
};