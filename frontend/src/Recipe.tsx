import { useEffect, useState } from "react";
import { useParams } from "react-router";
import { MealDetails } from "./MealDetails";

export default function Recipe() {
    const [mealDetails, setMealDetails] = useState<MealDetails>();
    const { id } = useParams();

    async function getMeal() {
        const data = await fetch(`http://localhost:8080/meals/${id}`);
        const result = await data.json();
        return result;
    }

    useEffect(() => {
        getMeal().then(mealDetails => setMealDetails(mealDetails));
    });

    if (!mealDetails) {
        return <p>Loading...</p>;
    }

    return (
        <div>
            <div>
                <h1>{mealDetails.meal.name}</h1>
                <p>{`Calories: ${mealDetails.meal.calories}`}</p>
                <p>{`Prep in ${mealDetails.meal.prepMins} min`}</p>
                <p>{`Ready in ${mealDetails.meal.cookMins} min`}</p>
            </div>
            <div>
                <h1>Ingredients</h1>
                <ul>
                    {mealDetails.ingMeasurements.map(ingMeasurement => (
                        <li key={ingMeasurement.name}>
                            {`${ingMeasurement.name} ${ingMeasurement.measurement}`}
                        </li>
                    ))}
                </ul>
            </div>
            <div>
                <h1>Instructions</h1>
                <ul>
                    {mealDetails.instructions.map(instruction => (
                        <li key={instruction.id}>
                            <p>{`${instruction.stepNumber}) ${instruction.instruction}`}</p>
                        </li>
                    ))}
                </ul>
            </div>
        </div>
    );
}