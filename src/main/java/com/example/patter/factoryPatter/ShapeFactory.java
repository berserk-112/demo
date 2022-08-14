package com.example.patter.factoryPatter;

import com.example.patter.Circle;
import com.example.patter.Rectangle;
import com.example.patter.Shape;
import com.example.patter.Square;
import org.elasticsearch.common.Strings;

public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("Square")) {
            return new Square();
        }
        return null;
    }
}
