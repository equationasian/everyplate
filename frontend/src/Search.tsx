import { useEffect, useState } from "react";
import { Meal } from "./Meal";
import Card from "./Card";
import { Link } from "react-router";

export default function Search() {
    const [meals, setMeals] = useState<Meal[]>([]);

    async function getMeals() {
        const data = await fetch("http://localhost:8080/meals");
        const a = await data.json();
        return a["_embedded"]["mealList"];
    }

    useEffect(() => {
        getMeals().then(allMeals => setMeals(allMeals));
    }, []);

    return (
        <div>
            <h1>Meals</h1>
            <ul className="grid grid-cols-4 gap-7">
                {meals.map(meal => (
                    <li key={meal.id}>
                        <Link to={`/meals/${meal.id}`}>
                            <Card meal={meal} />
                        </Link>
                    </li>
                ))}
            </ul>
        </div>
    );
}