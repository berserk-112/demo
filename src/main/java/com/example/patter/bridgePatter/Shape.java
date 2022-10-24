package com.example.patter.bridgePatter;

public abstract class Shape {
    protected DrawAPI drawapi;
    protected Shape(DrawAPI drawapi) {
        this.drawapi = drawapi;
    }

    public abstract void draw();
}
