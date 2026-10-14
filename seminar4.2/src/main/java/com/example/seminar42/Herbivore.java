package com.example.seminar42;

import javafx.scene.paint.Color;

public class Herbivore extends Animal {
    private double startX;
    private double startY;
    private double squareSide = 80.0;
    private double speed = 2.0;
    private int state = 0;

    public Herbivore(double x, double y) {
        super(x, y, 40, 40);
        this.startX = x;
        this.startY = y;
        draw();
    }

    @Override
    public void draw() {
        gc.clearRect(0, 0, getWidth(), getHeight());

        gc.setFill(Color.LIGHTGRAY);
        gc.fillOval(10, 2, 6, 16);
        gc.fillOval(24, 2, 6, 16);

        gc.fillOval(5, 12, 30, 26);

        gc.setFill(Color.BLACK);
        gc.fillOval(12, 20, 3, 3);
        gc.fillOval(25, 20, 3, 3);
    }

    @Override
    public void move() {
        switch (state) {
            case 0:
                setLayoutX(getLayoutX() + speed);
                if (getLayoutX() >= startX + squareSide) {
                    setLayoutX(startX + squareSide);
                    state = 1;
                }
                break;

            case 1:
                setLayoutY(getLayoutY() + speed);
                if (getLayoutY() >= startY + squareSide) {
                    setLayoutY(startY + squareSide);
                    state = 2;
                }
                break;

            case 2:
                setLayoutX(getLayoutX() - speed);
                if (getLayoutX() <= startX) {
                    setLayoutX(startX);
                    state = 3;
                }
                break;

            case 3:
                setLayoutY(getLayoutY() - speed);
                if (getLayoutY() <= startY) {
                    setLayoutY(startY);
                    state = 0;
                }
                break;
        }
    }
}
