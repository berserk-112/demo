package com.example.patter.decoratorPatter;

import com.example.patter.Circle;
import com.example.patter.Shape;

public class DecoratorPatterDemo {
    public static void main(String[] args){
        Shape circle = new Circle();
        Shape redShapeDecorator = new RedShapeDecorator(circle);
        circle.draw();
        redShapeDecorator.draw();
    }
}
