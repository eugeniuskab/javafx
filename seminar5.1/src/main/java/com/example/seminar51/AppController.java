package com.example.seminar51;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AppController {
    @FXML private ListView<String> list;
    @FXML private TextField name;

    private ObservableList<String> participants = FXCollections.observableArrayList();

    @FXML public void initialize() {
        list.setItems(participants);

        list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                name.setText(newValue);
            }
        });
    }

    @FXML private void onAddClick() {
        String enteredName = name.getText();
        if (enteredName != null) {
            participants.add(enteredName.trim());
            name.clear();
        }
    }

    @FXML private void onUpdateClick() {
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        String updatedName = name.getText();
        if (selectedIndex != -1 && updatedName != null) {
            participants.set(selectedIndex, updatedName.trim());
            name.clear();
            list.getSelectionModel().clearSelection();
        }
    }

    @FXML private void onRemoveClick() {
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        if (selectedIndex !=  -1) {
            participants.remove(selectedIndex);
            name.clear();
        }
    }
}
