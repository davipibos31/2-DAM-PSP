package com.example.ejercicio10;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private ComboBox<String> combo1;

    @FXML
    private Label welcomeText;

    @FXML
    private Label welcomeText1;

    @FXML
    private Label welcomeText2;

    @FXML
    private Label welcomeText3;

    @FXML
    private TextField textfield1;

    @FXML
    private TextField textfield2;

    @FXML
    private TextField textfield3;

    @FXML
    private Button buton1;

    public void initialize() {
        combo1.setItems(FXCollections.observableArrayList("+", "-", "*", "/"));

    }
    @FXML
    protected void btnGo(ActionEvent actionEvent) {
        int num1 = Integer.parseInt(textfield1.getText());
        int num2 = Integer.parseInt(textfield2.getText());

        switch (combo1.getValue()) {
            case "+":
                textfield3.setText(String.valueOf(num1 + num2));
                break;
            case "-":
                textfield3.setText(String.valueOf(num1 - num2));
                break;
            case "*":
                textfield3.setText(String.valueOf(num1 * num2));
                break;
            case "/":
                textfield3.setText(String.valueOf(num1 / num2));
                break;
        }
    }


}