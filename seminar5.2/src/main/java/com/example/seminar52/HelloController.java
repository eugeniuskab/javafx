package com.example.seminar52;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private ListView<Item> listView;

    @FXML
    private TextField nameField;

    @FXML
    private Spinner<Integer> countSpinner;

    @FXML
    private Label totalLabel;

    @FXML
    private ObservableList<Item> items = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
        countSpinner.setValueFactory(valueFactory);

        listView.setItems(items);

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                nameField.setText(newValue.getName());
                countSpinner.getValueFactory().setValue(newValue.getCount());
            }
        });
        updateTotalCount();
    }
    private void updateTotalCount() {
        totalLabel.setText("Items count: " + items.size());
    }

    @FXML
    private void onAddClick() {
        String name = nameField.getText();
        int count = countSpinner.getValue();

        if (name != null && !name.trim().isEmpty()) {
            items.add(new Item(name.trim(), count));
            clearForm();
            updateTotalCount();
        }
    }

    @FXML
    private void onUpdateClick() {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        String name = nameField.getText();
        int count = countSpinner.getValue();

        if (selectedIndex != -1 && name != null && !name.trim().isEmpty()) {
            items.set(selectedIndex, new Item(name.trim(), count));
            clearForm();
            listView.getSelectionModel().clearSelection();
            updateTotalCount();
        }
    }

    @FXML
    private void onRemoveClick() {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            items.remove(selectedIndex);
            clearForm();
            updateTotalCount();
        }
    }

    private void clearForm() {
        nameField.clear();
        countSpinner.getValueFactory().setValue(1);
    }
}
