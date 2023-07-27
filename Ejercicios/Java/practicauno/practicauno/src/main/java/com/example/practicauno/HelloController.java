package com.example.practicauno;

import com.example.practicauno.model.Fight;
import com.example.practicauno.utils.MessageUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.practicauno.utils.FileUtils.loadFlights;
import static com.example.practicauno.utils.FileUtils.saveFlights;

//CARGAMOS LAS FXML DEL SCREENBUILDER
public class HelloController {

    @FXML
    private AnchorPane anchorpanebo;

    @FXML
    private AnchorPane anchorpaneta;

    @FXML
    private Button btna;

    @FXML
    private Button btnd;

    @FXML
    private Button btnf;

    @FXML
    private ComboBox<String> combo;

    @FXML
    private HBox hboxcobu;

    @FXML
    private HBox hboxdedu;

    @FXML
    private HBox hboxfides;

    @FXML
    private Label labeldeparture;

    @FXML
    private Label labeldestination;

    @FXML
    private Label labelduration;

    @FXML
    private Label labelfightnumber;

    @FXML
    private SplitPane splitpane;

    @FXML
    private TableColumn<Fight, LocalDateTime> tablecolumndeparture;

    @FXML
    private TableColumn<Fight, String> tablecolumndestination;

    @FXML
    private TableColumn<Fight, LocalTime> tablecolumnduration;

    @FXML
    private TableColumn<Fight, String> tablecolumnfightnumber;

    @FXML
    private TableView<Fight> tableview;

    @FXML
    private TextField textfielddeparture;

    @FXML
    private TextField textfielddestination;

    @FXML
    private TextField textfieldduration;

    @FXML
    private TextField textfieldfightnumber;

    @FXML
    private Button btnchart;

    //INICIALIZAMOS LAS PROPIEDADES DE LA TABLA
    public void initialize() throws MessageUtils {
        try {
            tablecolumnfightnumber.setCellValueFactory(new PropertyValueFactory<>("numvul"));
            tablecolumndestination.setCellValueFactory(new PropertyValueFactory<>("lugar"));

            tablecolumndeparture.setCellValueFactory(new PropertyValueFactory<>("fecha"));
            tablecolumnduration.setCellValueFactory(new PropertyValueFactory<>("duracion"));
            ObservableList<Fight>flights = FXCollections.observableArrayList();
            tableview.setItems(flights);

            combo.setItems(FXCollections.observableArrayList("Show all flights","Show flights to currently selected city", "Show long flights", "Show next 5 flights", "Show flight duration average"));
            combo.setPromptText("Please select one");
        } catch (Exception e) {
            throw new MessageUtils(e);
        }
    }
    private static List<Fight> l;

    //FUNCIÓN QUE CARGA LA LISTA Y ELIMINA EL ELEMENTO PARA DESPUÉS GUARDARLO
    public void delete2(int position) throws MessageUtils {
        try {
            l = loadFlights();
            assert l != null;
            l.remove(position);
            saveFlights(l);
        } catch (Exception e) {
            throw new MessageUtils(e);
        }
    }
    //FUNCIÓN DEL BOTON DELETE ELIMINA EL SELECCIONADO DE LA TABLA
    @FXML
    void delete(ActionEvent event) throws MessageUtils {
        try {
            int position = tableview.getSelectionModel().getSelectedIndex();
            tableview.getSelectionModel().getSelectedItems();
            delete2(position);

            tableview.setItems(FXCollections.observableArrayList(l));
        } catch (Exception e) {
            throw new MessageUtils(e);
        }
    }
    //EN ESTA FUNCIÓN REALIZO LOS FILTROS EN LA ACCIÓN DEL BOTON APLICAR FILTRO
    @FXML
    void filtroapply(ActionEvent event) throws MessageUtils {
        try {
            //noinspection UnusedAssignment
            List<Fight> aux= null;
            ObservableList<Fight> fls =  FXCollections.observableArrayList(loadFlights());
            ObservableList<Fight> flights2 = FXCollections.observableArrayList(loadFlights());
            if(combo.getSelectionModel().getSelectedItem().contains("Show all flights")){
                tableview.setItems(flights2);
            }else if(combo.getSelectionModel().getSelectedItem().contains("Show flights to currently selected city")){
                Fight fl= tableview.getSelectionModel().getSelectedItem();
                aux=fls.stream().filter(f->f.getNumvul().equals(fl.getNumvul())).collect(Collectors.toList());
                flights2.clear();
                flights2.addAll(aux);
                tableview.setItems(flights2);
            }
            else if(combo.getSelectionModel().getSelectedItem().contains("Show long flights")){

                aux=fls.stream().filter(f->f.getDuracion().getHour()>3).collect(Collectors.toList());
                flights2.clear();
                flights2.addAll(aux);
                tableview.setItems(flights2);
            }
            else if(combo.getSelectionModel().getSelectedItem().contains("Show next 5 flights")){
                aux=fls.stream().filter(f->f.getFecha().isAfter(LocalDateTime.now())).sorted(Comparator.comparing
                        (Fight::getDuracion)).limit(5).collect(Collectors.toList());
                flights2.clear();
                flights2.addAll(aux);
                tableview.setItems(flights2);
            }
            else if(combo.getSelectionModel().getSelectedItem().contains("Show flight duration average")){
                aux=fls.stream().filter(f->f.getDuracion().isBefore(f.getDuracion())).collect(Collectors.toList());
                flights2.clear();
                flights2.addAll(aux);
                tableview.setItems(flights2);
            }
        } catch (Exception e) {
            throw new MessageUtils(e);
        }
    }
    //EN ESTA FUNCIÓN REALIZO LA ACCION DEL BOTON ADD PARA AÑADIR A LA TABLA Y A LA LISTA GUARDANDOLO EN EL FICHERO
    @FXML
    void meter(ActionEvent event) throws MessageUtils {
        try {
            String numVuelo = textfieldfightnumber.getText();
            String destino = textfielddestination.getText();
            String salida = textfielddeparture.getText();
            String duracion = textfieldduration.getText();

            List<Fight> flights = loadFlights();

            if (flights != null) {
                Fight f = new Fight(numVuelo, destino, LocalDateTime.parse(salida), LocalTime.parse(duracion));
                flights.add(f);
            }
            saveFlights(flights);

            ObservableList<Fight> fl =  FXCollections.observableArrayList();
            assert flights != null;
            fl.addAll(flights);
            tableview.setItems(fl);
        } catch (Exception e) {
            throw new MessageUtils(e);
        }
    }

    //TODO ESTO ES ADICIONAL Y ES PARA SUBIR NOTA

    //EN ESTA FUNCIÓN ES PARA CARGAR EL SIGUIENTE FXML DONDE SE MUESTRA EL GRÁFICO DE PIECHART
    @FXML
    void abrirchart(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pie-chart.fxml"));
        Parent view1 = loader.load();
        Scene view1Scene = new Scene(view1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(view1Scene);
        stage.show();
    }
}