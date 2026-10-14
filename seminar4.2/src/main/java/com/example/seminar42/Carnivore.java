package com.example.seminar42;

import javafx.scene.paint.Color;

public class Carnivore extends Animal {
    private double speed = 3.0;
    private int direction = 0;
    private boolean clockwise = true;

    private double minX = 10;
    private double minY = 10;
    private double maxX = 550;
    private double maxY = 350;

    public Carnivore(double x, double y) {
        super(x, y, 40, 40);
        draw();
    }

    @Override
    public void draw() {
        gc.clearRect(0, 0, getWidth(), getHeight());

        gc.setFill(Color.DARKRED);
        gc.fillPolygon(new double[]{6, 14, 10}, new double[]{14, 14, 2}, 3);
        gc.fillPolygon(new double[]{26, 34, 30}, new double[]{14, 14, 2}, 3);

        gc.setFill(Color.BLACK);
        gc.fillOval(4, 10, 32, 28);

        gc.setFill(Color.GOLD);
        gc.fillOval(10, 18, 7, 7);
        gc.fillOval(23, 18, 7, 7);

    }

    @Override
    public void move() {
        if (getParent() != null && getParent() instanceof javafx.scene.layout.Pane) {
            javafx.scene.layout.Pane parentPane = (javafx.scene.layout.Pane) getParent();
            if (parentPane.getWidth() > 100) {
                maxX = parentPane.getWidth() - getWidth() - 10;
            }
            if (parentPane.getHeight() > 100) {
                maxY = parentPane.getHeight() - getHeight() - 10;
            }
        }

        if (clockwise) {
            moveClockwise();
        } else {
            moveCounterClockwise();
        }
    }

    private void moveClockwise() {
        switch (direction) {
            case 0:
                setLayoutX(getLayoutX() + speed);
                if (getLayoutX() >= maxX) {
                    setLayoutX(maxX);
                    direction = 1;
                }
                break;
            case 1:
                setLayoutY(getLayoutY() + speed);
                if (getLayoutY() >= maxY) {
                    setLayoutY(maxY);
                    direction = 2;
                }
                break;
            case 2:
                setLayoutX(getLayoutX() - speed);
                if (getLayoutX() <= minX) {
                    setLayoutX(minX);
                    direction = 3;
                }
                break;
            case 3:
                setLayoutY(getLayoutY() - speed);
                if (getLayoutY() <= minY) {
                    setLayoutY(minY);
                    direction = 0;
                }
                break;
        }
    }

    private void moveCounterClockwise() {
        switch (direction) {
            case 0:
                setLayoutX(getLayoutX() - speed);
                if (getLayoutX() <= minX) {
                    setLayoutX(minX);
                    direction = 3;
                }
                break;
            case 3:
                setLayoutY(getLayoutY() + speed);
                if (getLayoutY() >= maxY) {
                    setLayoutY(maxY);
                    direction = 2;
                }
                break;
            case 2:
                setLayoutX(getLayoutX() + speed);
                if (getLayoutX() >= maxX) {
                    setLayoutX(maxX);
                    direction = 1;
                }
                break;
            case 1:
                setLayoutY(getLayoutY() - speed);
                if (getLayoutY() <= minY) {
                    setLayoutY(minY);
                    direction = 0;
                }
                break;
        }
    }

    public void reverseDirection() {
        this.clockwise = !this.clockwise;
    }
}