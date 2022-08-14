package com.example.patter.abstractFactoryPatter;

import com.example.patter.Color;
import com.example.patter.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
