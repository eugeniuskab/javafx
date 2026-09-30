package com.example.javafxhomework1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;



public class HelloController {
    @FXML private TextField heightField;
    @FXML private TextField weightField;
    @FXML private Label labelResult;

    @FXML protected void onCalculateClick() {
        try {
          double heightCm = Double.parseDouble(heightField.getText());
          double weightKg = Double.parseDouble(weightField.getText());

          if (heightCm <= 0 || weightKg <= 0) {
              showErrorAlert("Height and weight must be greater than zero.");
              return;
          }
          double heightM = heightCm / 100.0;
          double bmi = weightKg / (heightM * heightM);

          String category;
          if (bmi < 18.5) {
                category = "Underweight";
          } else if (bmi < 25.0) {
                category = "Normal weight";
          } else if (bmi < 30.0) {
                category = "Overweight";
          } else {
                category = "Obesity";
          }

          labelResult.setStyle("-fx-text-fill: black;");
          labelResult.setText(String.format("BMI: %.2f (%s)", bmi, category));

          Alert alert = new Alert(AlertType.INFORMATION);
          alert.setTitle("BMI Result");
          alert.setHeaderText("Category: " + category);
          alert.setContentText(String.format("Your BMI value is: %.2f", bmi));
          alert.showAndWait();
        } catch (NumberFormatException e) {
            labelResult.setStyle("-fx-text-fill: red;");
            labelResult.setText("Error: Invalid input!");
            showErrorAlert("Please, enter valid input for height and weight.");
        }
    }
    private void showErrorAlert(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid input");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
