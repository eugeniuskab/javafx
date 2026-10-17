package com.example.seminar4_homework1;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Ball extends Canvas {
    private GraphicsContext gc;
    private Timeline timer;

    private double dx = 2.5;
    private double dy = 2.5;

    private boolean isPaused = false;

    private double paneWidth = 600.0;
    private double paneHeight = 400.0;

    public Ball(double x, double y, double diameter) {
        super(diameter, diameter);
        this.gc = getGraphicsContext2D();

        setLayoutX(x);
        setLayoutY(y);

        draw();
        setOnMousePressed(event -> togglePause());

        timer = new Timeline(new KeyFrame(Duration.millis(20), e -> move()));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    public void draw() {
        gc.clearRect(0,0,getWidth(), getHeight());
        gc.setFill(Color.DODGERBLUE);
        gc.fillOval(0,0,getWidth(), getHeight());
    }

    public void move() {
        if (getParent() instanceof Pane) {
            Pane parentPane = (Pane) getParent();
            paneWidth = parentPane.getWidth();
            paneHeight = parentPane.getHeight();
        }

        setLayoutX(getLayoutX() + dx);
        setLayoutY(getLayoutY() + dy);

        if (getLayoutX() <= 0) {
            setLayoutX(0);
            dx = -dx;
        } else if (getLayoutX() + getWidth() >= paneWidth) {
            setLayoutX(paneWidth - getWidth());
            dx = -dx;
        }

        if (getLayoutY() <= 0) {
            setLayoutY(0);
            dy = -dy;
        } else if (getLayoutY() + getHeight() >= paneHeight) {
            setLayoutY(paneHeight - getHeight());
            dy = -dy;
        }
    }

    public void togglePause() {
        if (isPaused) {
            timer.play();
            isPaused = false;
        } else {
            timer.pause();
            isPaused = true;
        }
    }

    public void speedUp() {
        dx *= 1.25;
        dy *= 1.25;
    }

    public void slowDown() {
        dx *= 0.8;
        dy *= 0.8;
    }
}
