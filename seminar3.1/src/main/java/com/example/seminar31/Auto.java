package com.example.seminar31;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Auto extends Canvas {
    private final double carWidth = 80;
    private final double carHeight = 40;

    private double sceneWidth = 600;
    private double sceneHeight = 400;

    private boolean automatika = false;
    private boolean moving = true;
    private double speedX = 4.0;

    private final double manualStep = 10.0;

    private Timeline timer;
    private GraphicsContext gc;

    public Auto() {
        super(80, 40);
        this.gc = this.getGraphicsContext2D();

        setLayoutX(50);
        setLayoutY(150);

        vykresli();

        setOnMousePressed(e -> toggleMovement());

        timer = new Timeline(new KeyFrame(Duration.millis(16), e -> {
            if (automatika && moving) {
                pohybAutomatika();
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
    }

    public void vykresli() {
        gc.clearRect(0, 0, getWidth(), getHeight());

        gc.setFill(Color.DODGERBLUE);
        gc.fillRect(0, 0, carWidth, carHeight);

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeRect(0, 0, carWidth, carHeight);
    }

    private void pohybAutomatika() {
        double currentX = getLayoutX();
        double nextX = currentX + speedX;

        if (nextX + carWidth >= sceneWidth) {
            speedX = -Math.abs(speedX);
        } else if (nextX <= 0) {
            speedX = Math.abs(speedX);
        }

        setLayoutX(getLayoutX() + speedX);
    }

    public void handleKeyPress(KeyCode code) {
        if (automatika || !moving) {
            return;
        }

        switch (code) {
            case UP:
                if (getLayoutY() - manualStep >= 0) {
                    setLayoutY(getLayoutY() - manualStep);
                }
                break;
            case DOWN:
                if (getLayoutY() + carHeight + manualStep <= sceneHeight) {
                    setLayoutY(getLayoutY() + manualStep);
                }
                break;
            case LEFT:
                if (getLayoutX() - manualStep >= 0) {
                    setLayoutX(getLayoutX() - manualStep);
                }
                break;
            case RIGHT:
                if (getLayoutX() + carWidth + manualStep <= sceneWidth) {
                    setLayoutX(getLayoutX() + manualStep);
                }
                break;
            default:
                break;
        }
    }

    public void prepniRezim() {
        automatika = !automatika;
        if (automatika) {
            if (moving) {
                timer.play();
            }
        } else {
            timer.stop();
        }
    }

    public void toggleMovement() {
        moving = !moving;
        if (automatika) {
            if (moving) {
                timer.play();
            } else {
                timer.stop();
            }
        }
    }

    public void setSceneBounds(double width, double height) {
        this.sceneWidth = width;
        this.sceneHeight = height;
    }

    public boolean isAutomatika() {
        return automatika;
    }

    public boolean isMoving() {
        return moving;
    }
}