package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static com.example.demo.Food.readFile;
import static com.example.demo.Food.saveFile;

@SuppressWarnings("unchecked")
public class HelloController {

    @FXML
    private BorderPane borderpane;

    @FXML
    private Button btna;

    @FXML
    private Button btnchart;

    @FXML
    private ComboBox<String> combo;

    @FXML
    private HBox hboxfoodcategory;

    @FXML
    private HBox hboxfoodname;

    @FXML
    private HBox hboxwei;

    @FXML
    private Label labelfoodcategory;

    @FXML
    private Label labelfoodname;

    @FXML
    private Label labelwei;

    @FXML
    private SplitPane splitpane;

    @FXML
    private TableView<Food> tableview;

    @SuppressWarnings("unused")
    @FXML
    private TableColumn<Food, String> tablecolumnfoodname;

    @SuppressWarnings("unused")
    @FXML
    private TableColumn<Food, String> tablecolumnfootcategory;

    @SuppressWarnings("unused")
    @FXML
    private TableColumn<Food, Float> tablecolumnweioz;

    @SuppressWarnings("unused")
    @FXML
    private TableColumn<Food, Integer> tableweig;

    @FXML
    private TextField textfieldname;

    @FXML
    private TextField textfieldwei;

    @FXML
    private Button btndelete;

    public static ObservableList<Food> food;
    public void initialize() {

        food = FXCollections.observableArrayList(
                new Food(" Potatoes", "Fruits and vegetables", 200),
                new Food(" Chicken", "Meat and fish", 300),
                new Food(" Milkshake", "Milk derivatives", 250),
                new Food(" Salmon", "Meat and fish", 300)
        );
        //noinspection rawtypes
        tablecolumnfoodname.setCellValueFactory(new PropertyValueFactory("name"));
        //noinspection rawtypes
        tablecolumnfootcategory.setCellValueFactory(new PropertyValueFactory("category"));
        //noinspection rawtypes
        tableweig.setCellValueFactory(new PropertyValueFactory("weight"));
        //noinspection rawtypes
        tablecolumnweioz.setCellValueFactory(new PropertyValueFactory("weightInOz"));
        tableview.setItems(food);
    }

    @FXML
    void chart(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("secundario.fxml"));
        Parent view1 = loader.load();
        Scene view1Scene = new Scene(view1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(view1Scene);
        stage.show();
    }

    @FXML
    void meter(ActionEvent event) {
        if (textfieldname.getText().equals("") ||
                combo.getSelectionModel().getSelectedIndex() < 0 ||
                textfieldwei.getText().equals("")) {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Error");
            dialog.setHeaderText("Error adding data");
            dialog.setContentText("No field can be empty");
            dialog.showAndWait();
        } else {
            food.add(
                    new Food(
                            textfieldname.getText(),
                            combo.getSelectionModel().getSelectedItem(),
                            Integer.parseInt(textfieldwei.getText())
                    )
            );
            saveFile(food);
        }

    }
    public static List<Food> getFood() {
        return food;
    }
    private static List<Food> l;
    public void delete2(int position){

            l = readFile();
            assert l != null;
            l.remove(position);
    }
    @FXML
    void delete(ActionEvent event) {
        int position = tableview.getSelectionModel().getSelectedIndex();
        tableview.getSelectionModel().getSelectedItems();
        delete2(position);

        tableview.setItems(FXCollections.observableArrayList(l));
    }

}
