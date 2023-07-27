package com.example.httpservice;

import com.example.httpservice.login.LoginRequest;
import com.example.httpservice.login.LoginResponse;
import com.example.httpservice.service.LoginService;
import com.example.httpservice.service.UsersService;
import com.example.httpservice.utils.ServiceUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    public Label welcomeText;

    @FXML
    public void onHelloButtonClick() {
        //welcomeText.setText("Welcome to JavaFX Application!");

//        // enviar datos
        LoginService lss = new LoginService("Javier", "admin");
        lss.start(); // lo deja en un hilo secundario

        // recoger datos
        lss.setOnSucceeded(e -> { //recupero valor del hilo secundario
            LoginResponse response = lss.getValue();
            welcomeText.setText("Result: " + response.getToken());
            ServiceUtils.setToken(response.getToken());
        });


//        UsersService usersservice = new UsersService();
//        usersservice.start();
//
//        usersservice.setOnSucceeded(e -> {
//            Users[] response = usersservice.getValue();
//            String lista = null;
//                for (int i = 0; i< response.length; i++){
//                    lista = response[i].getNombre() + " " + response[i].getContrasenya() + " " + response[i].getImage();
//                    System.out.println(response[i].getNombre() + " " + response[i].getContrasenya() + " " + response[i].getImage());
//                }
//
//            welcomeText.setText(lista);
//        });
    }
}