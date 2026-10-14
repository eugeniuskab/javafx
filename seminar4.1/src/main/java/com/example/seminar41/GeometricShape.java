package com.example.seminar41;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public abstract class GeometricShape extends Canvas {
    protected Color color;
    protected GraphicsContext gc;
    protected Timeline timer;

    public GeometricShape(double x, double y, double width, double height, Color color) {
        super(width, height);
        this.color = color;
        this.gc = getGraphicsContext2D();

        setLayoutX(x);
        setLayoutY(y);

        timer = new Timeline(new KeyFrame(Duration.millis(20), e -> move()));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    public abstract void draw();
    public abstract void  move();

    public void moveDownBy30() {
        setLayoutY(getLayoutY() + 30);
    }

    public void setColor(Color color) {
        this.color = color;
        draw();
    }

    public Color getColor() {
        return color;
    }
}
