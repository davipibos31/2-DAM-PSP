package com.ricardo_nacher.flightsfx;

import com.ricardo_nacher.model.Flight;
import com.ricardo_nacher.utils.FileUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import static com.ricardo_nacher.utils.FileUtils.loadFlights;
import static com.ricardo_nacher.utils.FileUtils.saveFlights;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField txtnumvuelo;
    @FXML
    private TextField txtdestino;
    @FXML
    private TextField txtsalida;
    @FXML
    private TextField txtduracion;

    @FXML
    private Button btnaceptar;
    @FXML
    private Button btnborrar;
    @FXML
    private Button btnaplicar;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TableColumn<Flight, String> num_vuelo;
    @FXML
    private TableColumn<Flight, String> nom_ciudad;

    @FXML
    private TableColumn<Flight, LocalDateTime> fechasalida_horasalida;
    @FXML
    private TableColumn<Flight, LocalTime> duracion_vuelo;
    @FXML
    private TableView<Flight> tablavuelo;


    public void initialize() {

        num_vuelo.setCellValueFactory(new PropertyValueFactory("num_vuelo"));
        nom_ciudad.setCellValueFactory(new PropertyValueFactory("nom_ciudad"));


        fechasalida_horasalida.setCellValueFactory(new PropertyValueFactory("fechasalida_horasalida"));
        duracion_vuelo.setCellValueFactory(new PropertyValueFactory("duracion_vuelo"));
        ObservableList<Flight> flights = FXCollections.observableArrayList();
        tablavuelo.setItems(flights);
    }

    @FXML
    protected void btnaceptar(ActionEvent actionEvent) {
        String numVuelo = txtnumvuelo.getText();
        String destino = txtdestino.getText();
        String salida = txtsalida.getText();
        String duracion = txtduracion.getText();


        List<Flight> flights = loadFlights();
        flights.add(new Flight(numVuelo, destino, LocalDateTime.parse(salida), LocalTime.parse(duracion)));

        saveFlights(flights);



       ObservableList<Flight> fl =  FXCollections.observableArrayList();
        fl.addAll(Objects.requireNonNull(flights));
        tablavuelo.setItems(fl);

    }


}