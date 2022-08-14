package com.example.patter.builderTest;

public class MealBuilder {
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new Pepsi());
        meal.addItem(new VegBurger());
        return meal;
    }

    public Meal prepareNoVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new Coke());
        meal.addItem(new ChickenBurger());
        return meal;
    }
}
