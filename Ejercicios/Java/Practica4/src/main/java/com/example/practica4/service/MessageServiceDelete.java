package com.example.practica4.service;

import com.example.practica4.http.ServiceUtils;
import com.example.practica4.models.MessageResponse;
import com.google.gson.Gson;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class MessageServiceDelete extends Service<Boolean> {
    String idProd;
    public MessageServiceDelete(String idProd) {
        this.idProd = idProd;
    }
    @Override
    protected Task<Boolean> createTask() {
        return new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                Gson gson = new Gson();
                String resp = ServiceUtils.getResponse(
                        "http://localhost:8080/messages/" + idProd,
                        null, "DELETE");
                System.out.println(resp);
                System.out.println(Boolean.parseBoolean(resp));
                return Boolean.parseBoolean(resp);
            }
        };
    }
}
