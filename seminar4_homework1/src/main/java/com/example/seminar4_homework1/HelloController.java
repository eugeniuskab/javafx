package com.example.seminar4_homework1;

import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML
    private Pane pane;
    private  Ball ball;

    @FXML
    protected void initialize() {
        ball = new Ball(50, 50, 40);
        pane.getChildren().add(ball);

        Platform.runLater(() -> {
            pane.getScene().setOnKeyPressed(this::handleKeyPress);
        });
    }

    private void handleKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.F) {
            ball.speedUp();
            System.out.println("Faster!");
        } else if (event.getCode() == KeyCode.S) {
            ball.slowDown();
            System.out.println("Slower!");
        }
    }

}
