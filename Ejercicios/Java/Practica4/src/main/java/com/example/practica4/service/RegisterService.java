package com.example.practica4.service;

import com.example.practica4.http.ServiceUtils;
import com.example.practica4.login.LoginRequest;
import com.example.practica4.models.Users;
import com.example.practica4.register.RegisterRequest;
import com.example.practica4.register.RegisterResponse;
import com.google.gson.Gson;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class RegisterService extends Service<Users> {
    public String nombre;
    public String password;
    public String image;

    public RegisterService(String nombre, String password,String image) {
        this.nombre = nombre;
        this.password = password;
        this.image = image;
    }
    public static Users result;
    @Override
    protected Task<Users> createTask() {
        return new Task<Users>() {
            @Override
            protected Users call() throws Exception {
                Gson gson = new Gson();

                String request = gson.toJson(new RegisterRequest(nombre,password,image));

                String result2 = ServiceUtils.getResponse("http://127.0.0.1:8081/register", request, "POST");
                System.out.println(result2);
                result = gson.fromJson(result2, Users.class);
                System.out.println(result);
                return result;
            }
        };
    }
}