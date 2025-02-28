import { Meal } from "./Meal";

export default function Card({ meal }: { meal: Meal }) {
    return (
        <div className="flex flex-col gap-3 border-1 border-solid rounded-sm border-green-300 transition duration-300 ease-in-out hover:-translate-y-2 hover:scale-110">
            <p>img placeholder</p>
            <div className="px-4 pb-4 flex flex-col gap-2">
                <p className="font-semibold text-lg">{meal.name}</p>
                <div className="flex justify-between">
                    <span className="text-sm">Prep in {meal.prepMins} min</span>
                    <span className="text-sm">Ready in {meal.cookMins} min</span>
                </div>
            </div>
        </div>
    );
}