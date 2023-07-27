package com.example.ejercicio09;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
   @FXML
    private ComboBox combo1;

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
}