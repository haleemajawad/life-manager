package com.example.lifemanager;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NormalCalculator {

    @FXML
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, addbtn, subtractbtn, divbtn, multiplybtn, cancelbtn, equalbtn;
    @FXML
    TextField calctxtfield;

    private double firstOperand = 0;
    private String currentOperator = "";

    public void initialize() {
        // Button actions for numbers
        btn1.setOnAction(e -> appendToTextField("1"));
        btn2.setOnAction(e -> appendToTextField("2"));
        btn3.setOnAction(e -> appendToTextField("3"));
        btn4.setOnAction(e -> appendToTextField("4"));
        btn5.setOnAction(e -> appendToTextField("5"));
        btn6.setOnAction(e -> appendToTextField("6"));
        btn7.setOnAction(e -> appendToTextField("7"));
        btn8.setOnAction(e -> appendToTextField("8"));
        btn9.setOnAction(e -> appendToTextField("9"));
        btn0.setOnAction(e -> appendToTextField("0"));

        // Button actions for operators
        addbtn.setOnAction(e -> setOperator("+"));
        subtractbtn.setOnAction(e -> setOperator("-"));
        multiplybtn.setOnAction(e -> setOperator("*"));
        divbtn.setOnAction(e -> setOperator("/"));

        // Equal button
        equalbtn.setOnAction(e -> calculateResult());

        // Clear button
        cancelbtn.setOnAction(e -> clear());
    }

    // Append number to the display
    private void appendToTextField(String number) {
        calctxtfield.appendText(number);
    }

    // Set the operator (+, -, *, /)
    private void setOperator(String operator) {
        firstOperand = Double.parseDouble(calctxtfield.getText());
        currentOperator = operator;
        calctxtfield.clear();


    }

    // Perform the calculation
    private void calculateResult() {
        double secondOperand = Double.parseDouble(calctxtfield.getText());
        double result = 0;

        switch (currentOperator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                if (secondOperand == 0) {
                    showError("Cannot divide by zero!");
                    return;
                }
                result = firstOperand / secondOperand;
                break;

        }

        calctxtfield.setText(String.valueOf(result));
        currentOperator = "";  // Reset operator for the next calculation

    }

    // Clear the display
    private void clear() {
        calctxtfield.clear();
        firstOperand = 0;
        currentOperator = "";
    }

    // Show error alert
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid Operation");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
