package com.example.seminar41;

import javafx.scene.paint.Color;

public class MyCircle extends GeometricShape {
    private double centerX;
    private double centerY;
    private double angle = 0;
    private double orbitRadius = 40;

    public MyCircle(double x, double y, Color color) {
        super(x, y, 40, 40, color);
        this.centerX = x;
        this.centerY = y;
        draw();
    }

    @Override
    public void draw() {
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.setFill(color);
        gc.fillOval(0, 0, getWidth(), getHeight());
    }

    @Override
    public void move() {
        angle += 0.05;

        double newX = centerX + orbitRadius * Math.cos(angle);
        double newY = centerY + orbitRadius * Math.sin(angle);

        setLayoutX(newX);
        setLayoutY(newY);
    }
}
