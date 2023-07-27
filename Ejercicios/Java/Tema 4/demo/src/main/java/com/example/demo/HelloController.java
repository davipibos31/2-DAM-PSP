package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button ButtonAccept;
    @FXML
    private MenuBar menu;

    @FXML
    private ListView<String> lista;

    public void initialize() {
        lista.setItems(FXCollections.observableArrayList("Jose", "Antonio", "Casa", "Coche"));
        lista.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.setPlaceholder(new Label("No se ve ningún dato."));
        colisbn.setCellValueFactory(new PropertyValueFactory("isbn"));
        coltitle.setCellValueFactory(new PropertyValueFactory("title"));
        colauthor.setCellValueFactory(new PropertyValueFactory("author"));

        ObservableList<Book> books = FXCollections.observableArrayList(
                new Book("128312", "Lengua", "Laura"),
                new Book("335343", "Matematicas", "Maria"),
                new Book("767565", "Fisica", "David")
        );

        table.setItems(books);
    }

    @FXML
    private TableView<Book> table;

    @FXML
    private TableColumn<Book, String> colisbn;

    @FXML
    private TableColumn<Book, String> coltitle;

    @FXML
    private TableColumn<Book, String> colauthor;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}