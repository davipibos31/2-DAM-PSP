package com.example.ejercicio11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

public class HelloController {

    private static double EUR_USD = 1.10;
    private static double EUR_GBP = 0.8;
    private static double USD_GBP = 0.7;
    @FXML
    private Label Label1;

    @FXML
    private Button Button1;

    @FXML
    private TextField TextField1;

    @FXML
    private MenuBar Menubar1;

    @FXML
    private Menu Menu1;

    @FXML
    private RadioMenuItem RadioMenuItem1;

    @FXML
    private RadioMenuItem RadioMenuItem2;

    @FXML
    private RadioMenuItem RadioMenuItem3;

    @FXML
    private RadioMenuItem RadioMenuItem4;

    @FXML
    private RadioMenuItem RadioMenuItem5;

    @FXML
    private RadioMenuItem RadioMenuItem6;


    public void initialize() {

    }
    @FXML
    private  void onkeyreleased(KeyEvent event){
        double number, result;
        try {
            number = Double.parseDouble(TextField1.getText());
        } catch (Exception e) {
            number = 0;
        }

        if (RadioMenuItem2.isSelected()) {
            result = number * EUR_GBP;
            Label1.setText("" + number + " EUR = " + result + " GBP");
        } else if (RadioMenuItem5.isSelected()) {
            result = number / EUR_GBP;
            Label1.setText("" + number + " GBP = " + result + " EUR");
        } else if (RadioMenuItem1.isSelected()) {
            result = number * EUR_USD;
            Label1.setText("" + number + " EUR = " + result + " USD");
        } else if (RadioMenuItem3.isSelected()) {
            result = number / EUR_USD;
            Label1.setText("" + number + " USD = " + result + " EUR");
        } else if (RadioMenuItem4.isSelected()) {
            result = number * USD_GBP;
            Label1.setText("" + number + " USD = " + result + " GBP");
        } else if (RadioMenuItem6.isSelected()) {
            result = number / USD_GBP;
            Label1.setText("" + number + " GBP = " + result + " USD");
        }
    }

    @FXML
    private void clearData(ActionEvent event) {
        TextField1.setText("");
        Label1.setText("");
    }
}