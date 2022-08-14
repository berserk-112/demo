package com.example.patter.abstractFactoryPatter;

import com.example.patter.Color;
import com.example.patter.Green;
import com.example.patter.Red;
import com.example.patter.Shape;

public class ColorFactory extends AbstractFactory{
    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }

        if (color.equalsIgnoreCase("RED")) {
           return new Red();
        } else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
