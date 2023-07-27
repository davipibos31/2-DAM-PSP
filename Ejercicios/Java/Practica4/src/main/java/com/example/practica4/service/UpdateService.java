package com.example.practica4.service;

import com.example.practica4.http.ServiceUtils;
import com.example.practica4.models.UsersResponse;
import com.example.practica4.register.RegisterRequest;
import com.google.gson.Gson;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class UpdateService extends Service<UsersResponse> {

    @Override
    protected Task<UsersResponse> createTask() {
        return new Task<UsersResponse>() {
            @Override
            protected UsersResponse call() throws Exception {
                Gson gson = new Gson();
                //String request = gson.toJson(new RegisterRequest(nombre,password,image));
                String result2 = ServiceUtils.getResponse("http://127.0.0.1:8081/users", null, "PUT");
                System.out.println(result2);

                UsersResponse result =  gson.fromJson(result2, UsersResponse.class);
                return result;
            }
        };
    }
}
