export interface Meal {
    id: number,
    name: string,
    calories: number,
    prepMins: number,
    cookMins: number,
    _links: {
        meals: string,
        self: string,
    },
};