package com.example.practica4;

import com.example.practica4.http.ServiceUtils;
import com.example.practica4.models.Users;
import com.example.practica4.service.RegisterService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;


import java.io.*;
import java.nio.file.Files;
import java.util.Objects;

public class HelloControllerRegister extends Window {

    @FXML
    private BorderPane borderpane;

    @FXML
    private Button btncancelar;

    @FXML
    private Button btnregistrar;

    @FXML
    private Button btnselecimage;

    @FXML
    private HBox hboxbotones;

    @FXML
    private HBox hboxcontrasenya;

    @FXML
    private HBox hboxrepitecon;

    @FXML
    private HBox hboxusuario;

    @FXML
    private ImageView imageview;

    @FXML
    private Label labelcontrasenya;

    @FXML
    private Label labelregistrar;

    @FXML
    private Label labelrepitecon;

    @FXML
    private Label labelusuario;

    @FXML
    private TextField txtcontrasenya;

    @FXML
    private TextField txtrepitecon;

    @FXML
    private TextField txtusuario;

    @FXML
    private VBox vboxabajo;

    @FXML
    private VBox vboxarriba;

    @FXML
    private VBox vboxcentral;

    @FXML
    private VBox vboximage;

    @FXML
    void atras(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();
        ServiceUtils.removeToken();
    }
    final Users[] response = new Users[1];
    @FXML
    void regUser(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(HelloController.class.getResource("hello-view.fxml")));
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();
    }

    @FXML
    void regUserPress(MouseEvent event) throws IOException {
        if (!Objects.equals(txtusuario.getText(), "") && !Objects.equals(txtcontrasenya.getText(), "") && !Objects.equals(txtrepitecon.getText(), "")) {
            if (Objects.equals(txtcontrasenya.getText(), txtrepitecon.getText())) {
                //enviar datos
                RegisterService lss = new RegisterService(txtusuario.getText(), txtcontrasenya.getText(), patchImagen);
                lss.start(); // lo deja en un hilo secundario
                // recoger datos
                lss.setOnSucceeded(e -> { //recupero valor del hilo secundario
                    response[0] = lss.getValue();
                   // System.out.println(response[0].getNombre());
                });
            }
        } else {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloController.class.getResource("register.fxml")));
            Scene scene = new Scene(root);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.toFront();
            appStage.show();
        }
    }
    public static String patchImagen;

    @FXML
    void selectbrowserimage(ActionEvent event) throws IOException {

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
}
