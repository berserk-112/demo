package com.example.patter.bridgePatter;

public class Circle extends Shape{
    private int radius, x, y;

    public Circle(int radius, int x, int y, DrawAPI drawapi) {
        super(drawapi);
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        drawapi.drawCircle(radius, x, y);
    }
}
