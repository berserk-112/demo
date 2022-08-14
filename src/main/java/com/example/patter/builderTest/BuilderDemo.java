package com.example.patter.builderTest;

public class BuilderDemo {
    public static void main(String[] args){
        MealBuilder mealBuilder = new MealBuilder();
        Meal mealVeg = mealBuilder.prepareVegMeal();
        Meal mealNoVeg = mealBuilder.prepareNoVegMeal();
        mealVeg.showItems();
        mealNoVeg.showItems();
    }
}
