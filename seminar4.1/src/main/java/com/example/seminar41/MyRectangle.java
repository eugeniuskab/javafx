package com.example.seminar41;

import javafx.scene.paint.Color;

public class MyRectangle extends GeometricShape {
    private double dx = 2.0;

    public MyRectangle(double x, double y, Color color) {
        super(x, y, 60, 40, color);
        draw();
    }

    @Override
    public void draw() {
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.setFill(color);
        gc.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public void move() {
        setLayoutX(getLayoutX() + dx);

        if (getLayoutX() <= 0 || getLayoutX() + getWidth() >= 600) {
            dx = -dx;
        }
    }
}
