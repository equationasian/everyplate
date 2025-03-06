import { Meal } from "./Meal";

export interface Instruction {
    id: number,
    meal: Meal,
    stepNumber: number,
    instruction: string,
};