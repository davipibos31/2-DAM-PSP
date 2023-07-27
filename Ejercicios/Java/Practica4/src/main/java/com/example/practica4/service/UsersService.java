package com.example.practica4.service;

import com.example.practica4.http.ServiceUtils;
import com.example.practica4.models.Users;
import com.example.practica4.models.UsersResponse;
import com.google.gson.Gson;
import javafx.concurrent.Service;
import javafx.concurrent.Task;


public class UsersService extends Service<UsersResponse> {

    @Override
    protected Task<UsersResponse> createTask() {
        return new Task<UsersResponse>() {
            @Override
            protected UsersResponse call() throws Exception {
                String result2 = ServiceUtils.getResponse("http://127.0.0.1:8081/users", null, "GET");
                System.out.println(result2);
                Gson gson = new Gson();
                UsersResponse result =  gson.fromJson(result2, UsersResponse.class);
                return result;
            }
        };
    }
}
