package com.example.patter.decoratorPatter;

import com.example.patter.Shape;

public class RedShapeDecorator extends ShapeDecorator{
    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        decoratorShape.draw();
        setBorder(decoratorShape);
    }
    public void setBorder(Shape shape) {
        System.out.println("Border is red");
    }

}
