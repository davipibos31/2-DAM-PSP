package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class HelloController {

    @FXML
    private ChoiceBox<String> choice;

    @FXML
    private Label label;

    @FXML
    private TextField txtFirst;

    @FXML
    private TextField txtResult;

    @FXML
    private TextField txtSecond;

    @FXML
    private Button btnAction;

    public void initialize() {
        choice.setItems(FXCollections.observableArrayList("+", " -", "*"));
       /* btnAction.setOnAction(event -> {

        });*/
        //label.setOnMouseEntered((e) -> label.setStyle("-fx-background-color:green;"));
        //label.setOnMouseExited((e) -> label.setStyle("-fx-background-color:none;"));
        // textField.setOnKeyPressed((e)->  label.setText(textField.getText()));
    }


    @FXML
    void handleButton(ActionEvent event) {
        try {

            String valueFirst = txtFirst.getText();
            String valueSecond = txtSecond.getText();

            double result = 0.0;

            Integer val1 = Integer.parseInt(valueFirst);
            Integer val2 = Integer.parseInt(valueSecond);

            switch (choice.getValue()) {
                case "+":
                    result = val1 + val2;
                    break;
                case "-":
                    result = val1 - val2;
                    break;
                case "*":
                    result = val1 * val2;
                    break;
                default:

            }
            txtResult.setText(String.valueOf(result));

        } catch (Exception ex) {
            txtResult.setText("Error");
        }

    }

    @FXML
    void onKeyListener(KeyEvent event) {

    }

    @FXML
    void onMouseEntered(MouseEvent event) {

    }

    @FXML
    void onMouseExited(MouseEvent event) {

    }
}