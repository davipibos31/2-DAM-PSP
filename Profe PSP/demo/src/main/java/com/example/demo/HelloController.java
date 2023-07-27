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
    private Button buttonAccept;

    @FXML
    private ListView<String> lista;

    @FXML
    private TableColumn<Book, String> colIsbn;
    @FXML
    private TableColumn<Book, String> colAuthor;
    @FXML
    private TableColumn<Book, String> colTitle;
    @FXML
    private TableView<Book> table;

    public void initialize() {
        lista.setItems(FXCollections.observableArrayList("Jose", "Antonio", "Casa", "Coche"));
        lista.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        table.setPlaceholder(new Label("No existe ningun dato."));

        colIsbn.setCellValueFactory(new PropertyValueFactory("isbn"));
        colAuthor.setCellValueFactory(new PropertyValueFactory("author"));
        colTitle.setCellValueFactory(new PropertyValueFactory("title"));

        ObservableList<Book> books = FXCollections.observableArrayList(
                new Book("hgfhgfhf","dfgdfhdf","hgfhgf"),
                new Book("hgfhgfhfg","hghgfhfg","fghgf"),
                new Book("hgfhgfhfg","ghgfhgfhgf","fghgfh")
        );

        table.setItems(books);

    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}