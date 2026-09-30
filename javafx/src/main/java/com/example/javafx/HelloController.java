package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class HelloController {
    @FXML private Label labelresult;
    @FXML private TextField textfield1, textfield2;

    private String operator = "";
    private double firstNumber = 0;
    private boolean startNewNumber = true;

    @FXML protected void onNumberClick(ActionEvent event) {
        if (startNewNumber) {
            textfield1.setText("");
            startNewNumber = false;
        }
        Button button = (Button) event.getSource();
        textfield1.setText(textfield1.getText() + button.getText());
    }
    @FXML protected void onOperatorClick(ActionEvent event) {
        String currentText = textfield1.getText();
        if (!currentText.isEmpty()) {
            Button button = (Button) event.getSource();
            firstNumber = Double.parseDouble(currentText);
            operator = button.getText();
            startNewNumber = true;
        }
    }

    @FXML protected void onEqualsClick(ActionEvent event) {
        if (operator.isEmpty() || startNewNumber) return;

        double secondNumber = Double.parseDouble(textfield1.getText());
        double result = 0;

        switch (operator) {
            case "+": result = firstNumber + secondNumber; break;
            case "-": result = firstNumber - secondNumber; break;
            case "*": result = firstNumber * secondNumber; break;
            case "/":
                if (secondNumber == 0) {
                    textfield1.setText("Error");
                    startNewNumber = true;
                    return;
                }
                result = firstNumber / secondNumber;
                break;
        }

        String formattedResult = (result % 1 == 0) ? String.valueOf((long) result) : String.valueOf(result);

        textfield1.setText(formattedResult);
        labelresult.setText("Result: " + formattedResult);

        if (textfield2 != null) {
            String formattedFirst = (firstNumber % 1 == 0) ? String.valueOf((long) firstNumber) : String.valueOf(firstNumber);
            String formattedSecond = (secondNumber % 1 == 0) ? String.valueOf((long) secondNumber) : String.valueOf(secondNumber);
            textfield2.setText(formattedFirst + " " + operator + " " + formattedSecond + " = " + formattedResult);
        }

        operator = "";
        startNewNumber = true;
    }

    @FXML protected void onClearClick(ActionEvent event) {
        textfield1.setText("");
        if (textfield2 != null) textfield2.setText("");
        labelresult.setText("Result:");
        firstNumber = 0;
        operator = "";
        startNewNumber = true;
    }
}
