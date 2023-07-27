package com.example.practica4;

import com.example.practica4.login.LoginResponse;
import com.example.practica4.http.ServiceUtils;
import com.example.practica4.service.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class HelloController {

    @FXML
    private BorderPane boderpane;

    @FXML
    private Button btniniciar;

    @FXML
    private HBox hboxcontrasenya;

    @FXML
    private HBox hboxusuario;

    @FXML
    private Hyperlink hyperlink;

    @FXML
    private Label labelcontrasenya;

    @FXML
    private Label labelusuario;

    @FXML
    private Label login;

    @FXML
    private PasswordField txtcontrasenya;

    @FXML
    private TextField txtusuario;

    @FXML
    private VBox vboxabajo;

    @FXML
    private VBox vboxarriba;

    @FXML
    private VBox vboxcentral;
    // al presionar el boton se genera el token con la comprobación del usuario y contraseña
    @FXML
    void iniciopresed(MouseEvent event) throws IOException {
        final LoginResponse[] response = new LoginResponse[1];
        if (!Objects.equals(txtusuario.getText(), "") && !Objects.equals(txtcontrasenya.getText(), "")) {
            //enviar datos
            LoginService lss = new LoginService(txtusuario.getText(), txtcontrasenya.getText());
            lss.start(); // lo deja en un hilo secundario
            // recoger datos
            lss.setOnSucceeded(e -> { //recupero valor del hilo secundario
                response[0] = lss.getValue();
                System.out.println(response[0].getToken());
                ServiceUtils.setToken(response[0].getToken());
            });
            usuario = txtusuario.getText();
        } else { // Pongo esto para que si es vacio se vaya al registro para que se registre dado que es vacio
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloController.class.getResource("register.fxml")));
            Scene scene = new Scene(root);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.toFront();
            appStage.show();
        }
    }

    public static String usuario;

    // Carga pestaña mensajes una vez el token se genera
    @FXML
    void inicio(ActionEvent event) throws IOException {

        if ( LoginService.result.token != null) {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloController.class.getResource("menssage.fxml")));
            Scene scene = new Scene(root);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.toFront();
            appStage.show();
        }
    }


    // Carga pestaña register
    @FXML
    void link(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("register.fxml")));
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();
    }
}
