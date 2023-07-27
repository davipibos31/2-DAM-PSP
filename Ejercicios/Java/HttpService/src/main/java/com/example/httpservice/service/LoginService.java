package com.example.httpservice.service;

import com.example.httpservice.login.LoginRequest;
import com.example.httpservice.login.LoginResponse;
import com.example.httpservice.utils.ServiceUtils;
import com.google.gson.Gson;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class LoginService extends Service<LoginResponse> {
    public String nombre;
    public String password;

    public LoginService(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    @Override
    protected Task<LoginResponse> createTask() {
       return new Task<LoginResponse>() {
           @Override
           protected LoginResponse call() throws Exception {
               LoginResponse result = null;
               Gson gson = new Gson();

               String request = gson.toJson(new LoginRequest(nombre,password));

               String result2 = ServiceUtils.getResponse("http://127.0.0.1:8081/login", request, "POST");
               System.out.println(result2);
               result = gson.fromJson(result2, LoginResponse.class);
               return result;
           }
       };
    }


}
