package com.example.practica4.service;

import com.example.practica4.http.ServiceUtils;
import com.example.practica4.login.LoginRequest;
import com.example.practica4.models.MessageResponse;
import com.example.practica4.models.Messages;
import com.example.practica4.models.UsersResponse;
import com.google.gson.Gson;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class MessageServiceSend extends Service<Messages> {
    public String message;
    public String image;
    public String sent;
    public String _id;
    public String from;
    public String to;
    public String __v;
    public Boolean ok;

    public MessageServiceSend(String to) {
        this.to = to;
    }

    @Override
    protected Task<Messages> createTask() {
        return new Task<Messages>() {
            @Override
            protected Messages call() throws Exception {
                Gson gson = new Gson();
                String request = gson.toJson(new Messages(from,message,image,sent));
                String result2 = ServiceUtils.getResponse("http://127.0.0.1:8081/message/" + to, request, "POST");
                System.out.println(result2);
                Messages result =  gson.fromJson(result2, Messages.class);
                return result;
            }
        };
    }
}
