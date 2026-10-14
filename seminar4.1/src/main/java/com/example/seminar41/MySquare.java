package com.example.seminar41;

import javafx.scene.paint.Color;

public class MySquare extends GeometricShape {
    private double dy = 2.0;

    public MySquare(double x, double y, Color color) {
        super(x, y, 40, 40, color);
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
        setLayoutY(getLayoutY() + dy);

        if (getLayoutY() <= 0 || getLayoutY() + getHeight() >= 450) {
            dy = -dy;
        }
    }
}
