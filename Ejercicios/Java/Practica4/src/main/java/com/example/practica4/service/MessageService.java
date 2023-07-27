package com.example.practica4.service;

import com.example.practica4.http.ServiceUtils;
import com.example.practica4.models.MessageResponse;
import com.google.gson.Gson;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class MessageService extends Service<MessageResponse> {

    @Override
    protected Task<MessageResponse> createTask() {
        return new Task<MessageResponse>() {
            @Override
            protected MessageResponse call() throws Exception {
                String result2 = ServiceUtils.getResponse("http://127.0.0.1:8081/messages", null, "GET");
                System.out.println(result2);
                Gson gson = new Gson();
                MessageResponse result =  gson.fromJson(result2, MessageResponse.class);
                return result;
            }
        };
    }
}
