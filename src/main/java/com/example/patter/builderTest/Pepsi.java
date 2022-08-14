package com.example.patter.builderTest;

public class Pepsi extends ColdDrink{
    @Override
    public float price() {
        return 1.5f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
