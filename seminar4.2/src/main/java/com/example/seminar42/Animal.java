package com.example.seminar42;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

public abstract class Animal extends Canvas {
    protected GraphicsContext gc;
    protected Timeline timer;
    private boolean isPaused = false;

    public Animal(double x, double y, double width, double height) {
        super(width, height);
        this.gc = getGraphicsContext2D();

        setLayoutX(x);
        setLayoutY(y);

        timer = new Timeline(new KeyFrame(Duration.millis(20), e -> move()));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    public abstract void draw();
    public abstract void move();

    public void togglePause() {
        if (isPaused) {
            timer.play();
            isPaused = false;
        } else {
            timer.pause();
            isPaused = true;
        }
    }

    public boolean isPaused() {
        return isPaused;
    }
}
