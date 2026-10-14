package com.example.seminar42;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.Random;

public class HelloController {

    @FXML
    private Pane canvasPane;

    private Random random = new Random();

    private double getRandomX() {
        double width = canvasPane.getWidth();
        if (width <= 100) width = 600; // фоллбэк под размер 600x400
        return 20 + random.nextDouble() * (width - 120);
    }

    private double getRandomY() {
        double height = canvasPane.getHeight();
        if (height <= 100) height = 400; // фоллбэк под размер 600x400
        return 20 + random.nextDouble() * (height - 120);
    }

    @FXML
    protected void onAddHerbivoreClick() {
        Herbivore herbivore = new Herbivore(getRandomX(), getRandomY());
        canvasPane.getChildren().add(herbivore);
    }

    @FXML
    protected void onAddCarnivoreClick() {
        Carnivore carnivore = new Carnivore(getRandomX(), getRandomY());
        canvasPane.getChildren().add(carnivore);
    }

    @FXML
    protected void onReverseCarnivoresClick() {
        for (Node node : canvasPane.getChildren()) {
            if (node instanceof Carnivore) {
                Carnivore carnivore = (Carnivore) node;
                carnivore.reverseDirection();
            }
        }
    }

    @FXML
    protected void onTogglePauseClick() {
        for (Node node : canvasPane.getChildren()) {
            if (node instanceof Animal) {
                Animal animal = (Animal) node;
                animal.togglePause();
            }
        }
    }
}