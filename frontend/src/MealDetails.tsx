import { Meal } from "./Meal";

export default function MealDetails({ meal }: { meal: Meal }) {
    return (
        <div>
            <p>{meal.name}</p>
        </div>
    );
}