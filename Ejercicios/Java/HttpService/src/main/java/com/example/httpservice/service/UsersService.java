package com.example.httpservice.service;

import com.example.httpservice.Users;
import com.example.httpservice.login.LoginRequest;
import com.example.httpservice.login.LoginResponse;
import com.example.httpservice.utils.ServiceUtils;
import com.google.gson.Gson;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.util.List;

public class UsersService extends Service<Users[]> {

    @Override
    protected Task<Users[]> createTask() {
        return new Task<Users[]>() {
            @Override
            protected Users[] call() throws Exception {
                Gson gson = new Gson();

                String result2 = ServiceUtils.getResponse("http://127.0.0.1:8081/users", null, "GET");
                System.out.println(result2);
                Users[] list = gson.fromJson(result2, Users[].class);
                System.out.println(list);

                return list;
            }
        };
    }


}
