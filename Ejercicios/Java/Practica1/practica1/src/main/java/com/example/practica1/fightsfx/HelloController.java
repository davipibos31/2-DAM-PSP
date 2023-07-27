package com.example.practica1.fightsfx;

import com.example.practica1.fightsfx.model.Fight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import static com.example.practica1.fightsfx.utils.FileUtils.loadFlights;
import static com.example.practica1.fightsfx.utils.FileUtils.saveFlights;

public class HelloController {
    @FXML
    public BorderPane borderPane1;

    @FXML
    public Button butona;

    @FXML
    public Button butond;

    @FXML
    public Button butonf;

    @FXML
    public HBox hbox1;

    @FXML
    public HBox hbox2;

    @FXML
    public HBox hbox3;

    @FXML
    public Label label1;

    @FXML
    public Label label2;

    @FXML
    public Label label3;

    @FXML
    public Label label4;

    @FXML
    public SplitPane splitPane1;

    @FXML
    public TableColumn<Fight, String> tableColumn1;

    @FXML
    public TableColumn<Fight, String> tableColumn2;

    @FXML
    public TableColumn<Fight, LocalDateTime> tableColumn3;

    @FXML
    public TableColumn<Fight, LocalTime> tableColumn4;

    @FXML
    public TableView<Fight> tableView1;

    @FXML
    public TextField textField1;
    @FXML
    public TextField textField2;

    @FXML
    public TextField textField3;

    @FXML
    public TextField textField4;

    @FXML
    public ComboBox<String> comboBox;

    @FXML
    public void initialize() {

        tableColumn1.setCellValueFactory(new PropertyValueFactory<>("tableColumn1"));
        tableColumn2.setCellValueFactory(new PropertyValueFactory<>("tableColumn2"));


        tableColumn3.setCellValueFactory(new PropertyValueFactory<>("tableColumn3"));
        tableColumn4.setCellValueFactory(new PropertyValueFactory<>("tableColumn4"));
        ObservableList<Fight> flights = FXCollections.observableArrayList();
        tableView1.setItems(flights);
    }

    @FXML
    public void btna(ActionEvent actionEvent) {
        String numVuelo = textField1.getText();
        String destino = textField2.getText();
        String salida = textField3.getText();
        String duracion = textField4.getText();


        List<Fight> flights = loadFlights();
        if (flights != null) {
            flights.add(new Fight(numVuelo, destino, LocalDateTime.parse(salida), LocalTime.parse(duracion)));
        }
        saveFlights(flights);

        ObservableList<Fight> fl = FXCollections.observableArrayList();
        fl.addAll(Objects.requireNonNull(flights));
        tableView1.setItems(fl);
    }
}