package com.example.demotabla;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class HelloController {

    @FXML
    private TableColumn<Users, String> columnc1;

    @FXML
    private TableColumn<Users, String> columnc2;

    @FXML
    private TableView<Users> table;

    @FXML
    private VBox vbox;

}