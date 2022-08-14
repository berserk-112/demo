package com.example.patter.abstractFactoryPatter;

import com.example.patter.Shape;

public class AbstractFactoryDemo {
    public static void main(String[] args){
      //
        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");

        shapeFactory.getShape("RECTANGLE").draw();
        shapeFactory.getShape("SQUARE").draw();
        shapeFactory.getShape("CIRCLE").draw();

        colorFactory.getColor("RED").fill();
        colorFactory.getColor("GREEN").fill();
    }
}
