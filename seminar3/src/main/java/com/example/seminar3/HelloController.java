package com.example.seminar3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML
    private Pane mainPane;
    private Semafor semafor;

    @FXML
    public void initialize() {
        semafor = new Semafor();
        mainPane.getChildren().add(semafor);
    }

    @FXML
    protected void onChangeModeClick() {
        semafor.changeMode();
    }

    @FXML
    protected void onToggleClick() {
        semafor.toggle();
    }

    @FXML
    protected void onToggleOnOffClick() {
        semafor.toggleOnOff();
    }
}
