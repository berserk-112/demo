package com.example.patter.decoratorPatter;

import com.example.patter.Shape;

public abstract class ShapeDecorator implements Shape {
    Shape decoratorShape;

    public ShapeDecorator(Shape decoratorShape) {
        this.decoratorShape = decoratorShape;
    }
}
