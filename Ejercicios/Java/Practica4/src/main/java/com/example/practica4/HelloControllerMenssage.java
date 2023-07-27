package com.example.practica4;

import com.example.practica4.models.Messages;
import com.example.practica4.models.Users;
import com.example.practica4.service.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class HelloControllerMenssage {
    @FXML
    private TableView<Messages> TableView;

    @FXML
    private TableView<Users> TableViewUsers;

    @FXML
    private TableColumn<Users, String> avaCol;
    @FXML
    private Button btnchangeimagen;

    @FXML
    private Button btndeletemen;

    @FXML
    private Button btnrefrescar;

    @FXML
    private Button btnselectimage;

    @FXML
    private Button btnsendmen;

    @FXML
    private HBox hboxarriba;

    @FXML
    private HBox hboxcentral;

    @FXML
    private HBox hboxfinal;

    @FXML
    private TableColumn<Messages, String> imagen;

    @FXML
    private ImageView imageview;

    @FXML
    private Label labelmens;

    @FXML
    private Label labelnombre;

    @FXML
    private Label labelsendmen;

    @FXML
    private Label labeltitulo;

    @FXML
    private Label labelusers;

    @FXML
    private TableColumn<Messages, String> mensaje;

    @FXML
    private TableColumn<Users, String> nomCol;

    @FXML
    private TableColumn<Messages, String> sent;

    @FXML
    private TextField txtsendmen;

    @FXML
    private VBox vboxcentral;

    @FXML
    private VBox vboxcuartoinicial;

    @FXML
    private VBox vboxfinal;

    @FXML
    private VBox vboxinicialarriba;

    @FXML
    private VBox vboxsegundoinicial;

    @FXML
    private VBox vboxterceroinicial;

    @FXML
    private HBox hboxme;

    @FXML
    private ImageView imageviewmen;

    public ObservableList<Users> obs = FXCollections.observableArrayList();
    public ObservableList<Messages> obs2 = FXCollections.observableArrayList();

    @FXML
    void refrescar(ActionEvent event) {
        //Limpio la tabla
        TableViewUsers.getItems().clear();

        //GET users
        UsersService usersservice = new UsersService();
        usersservice.start();
        usersservice.setOnSucceeded(e -> {
            obs.addAll(usersservice.getValue().users);
            TableViewUsers.setItems(obs);
        });

        //Limpio la tabla
        TableView.getItems().clear();

        //GET messages
        MessageService messageservice = new MessageService();
        messageservice.start();
        messageservice.setOnSucceeded(e -> {
            obs2.addAll(messageservice.getValue().messages);
            TableView.setItems(obs2);
        });
    }
    public static String patchImagen;
    @FXML
    void changeImage(ActionEvent event) throws IOException {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        chooser.setInitialDirectory(new File(System.getProperty("user.home")));
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files","*.bmp", "*.png", "*.jpg", "*.gif"));
        File file = chooser.showOpenDialog(new Stage());
        if(file != null) {
            byte[] btImagen = Files.readAllBytes(file.toPath());
            Image img = new Image(new ByteArrayInputStream(btImagen), 199, 199, false, false);
            imageview.setImage(img);
            patchImagen = file.getPath();

        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Please Select a File");
            /*alert.setContentText("You didn't select a file!");*/
            alert.showAndWait();
        }
    }

    public int indexmen;
    public String idmen;
    //INICIALIZAMOS LAS PROPIEDADES DE LAS TABLAS Y REALIZAMOS LOS DOS GET (USERS Y MESSAGES)
    public void initialize() {

        nomCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        avaCol.setCellValueFactory(new PropertyValueFactory<>("image"));
        mensaje.setCellValueFactory(new PropertyValueFactory<>("message"));
        sent.setCellValueFactory(new PropertyValueFactory<>("sent"));
        imagen.setCellValueFactory(new PropertyValueFactory<>("image"));

        //GET users
        UsersService usersservice = new UsersService();
        usersservice.start();
        usersservice.setOnSucceeded(e -> {
            obs.addAll(usersservice.getValue().users);
            TableViewUsers.setItems(obs);
        });

        //GET messages
        MessageService messageservice = new MessageService();
        messageservice.start();
        messageservice.setOnSucceeded(e -> {
            obs2.addAll(messageservice.getValue().messages);
            TableView.setItems(obs2);
        });

        labelnombre.setText(HelloController.usuario);

        TableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                //Check whether item is selected and set value of selected item to Label
                if(TableView.getSelectionModel().getSelectedItem() != null)
                {
                    btndeletemen.setDisable(false);
                    indexmen = TableView.getSelectionModel().getSelectedIndex();
                    idmen = TableView.getSelectionModel().getSelectedItem()._id;
                }
            }
        });
    }
    @FXML
    void selectimagemen(ActionEvent event) throws IOException {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        chooser.setInitialDirectory(new File(System.getProperty("user.home")));
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files","*.bmp", "*.png", "*.jpg", "*.gif"));
        File file = chooser.showOpenDialog(new Stage());
        if(file != null) {
            byte[] btImagen = Files.readAllBytes(file.toPath());
            Image img = new Image(new ByteArrayInputStream(btImagen), 199, 199, false, false);
            imageviewmen.setImage(img);
            patchImagen = file.getPath();

        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Please Select a File");
            /*alert.setContentText("You didn't select a file!");*/
            alert.showAndWait();
        }
    }

    @FXML
    void sendmen(ActionEvent event) {
        final Messages[] response = new Messages[1];
        Users a = TableViewUsers.getSelectionModel().getSelectedItem();
        MessageServiceSend send = new MessageServiceSend(a.get_id());
        //Messages person1 = new Messages("63d8348906faf1c3ad0cb36b", txtsendmen.getText(), HelloControllerMenssage.patchImagen, "31/31/31");
        send.start();
        send.setOnSucceeded(e -> {
            response[0] = send.getValue();
           // System.out.println(person1.get().messages);
            obs2.add(response[0]);
            System.out.println(send.getValue());
        });

    }
    @FXML
    void deletemen(ActionEvent event) {
        //MessageResponse person = TableView.getSelectionModel().getSelectedItem();

        MessageServiceDelete deleteProd = new MessageServiceDelete(idmen);
        deleteProd.start();
        deleteProd.setOnSucceeded(e -> {

            if(deleteProd.getValue()) { // Success
                obs2.remove(deleteProd.getValue());
                System.out.println(obs2.remove(TableView.getSelectionModel().getSelectedItem()));
            }
        });
    }

    @FXML
    void selecttablamen(TouchEvent event) {
        btndeletemen.setDisable(false);
    }

    @FXML
    void selecttableuser(TouchEvent event) {

    }
}