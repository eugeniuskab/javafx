package com.example.seminar31;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class HelloController {

    @FXML
    private Pane mainPane;

    @FXML
    private Button btnMode;

    private Auto auto;

    @FXML
    public void initialize() {
        auto = new Auto();
        auto.setSceneBounds(600, 400);
        mainPane.getChildren().add(auto);

        mainPane.setFocusTraversable(true);
        mainPane.setOnKeyPressed(event -> auto.handleKeyPress(event.getCode()));
    }

    @FXML
    protected void onModeClick() {
        if (auto != null) {
            auto.prepniRezim();
            mainPane.requestFocus();
        }
    }
}