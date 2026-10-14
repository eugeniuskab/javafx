package com.example.seminar41;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Random;

public class HelloController {

    @FXML
    private Pane canvasPane;

    private Random random = new Random();

    private double getRandomX() {
        double width = canvasPane.getWidth();
        if (width <= 60) width = 500;
        return random.nextDouble() * (width - 60);
    }

    private double getRandomY() {
        double height = canvasPane.getHeight();
        if (height <= 60) height = 350;
        return random.nextDouble() * (height - 60);
    }

    @FXML
    protected void onAddRectangleClick() {
        MyRectangle rect = new MyRectangle(getRandomX(), getRandomY(), Color.RED);
        canvasPane.getChildren().add(rect);
    }

    @FXML
    protected void onAddCircleClick() {
        MyCircle circle = new MyCircle(getRandomX(), getRandomY(), Color.GREEN);
        canvasPane.getChildren().add(circle);
    }

    @FXML
    protected void onAddSquareClick() {
        MySquare square = new MySquare(getRandomX(), getRandomY(), Color.ORANGE);
        canvasPane.getChildren().add(square);
    }

    @FXML
    protected void onColorCirclesClick() {
        for (Node node : canvasPane.getChildren()) {
            if (node instanceof MyCircle) {
                MyCircle circle = (MyCircle) node;
                circle.setColor(Color.BLUE);
            }
        }
    }

    @FXML
    protected void onMoveAllDownClick() {
        for (Node node : canvasPane.getChildren()) {
            if (node instanceof GeometricShape) {
                GeometricShape shape = (GeometricShape) node;
                shape.moveDownBy30();
            }
        }
    }
}