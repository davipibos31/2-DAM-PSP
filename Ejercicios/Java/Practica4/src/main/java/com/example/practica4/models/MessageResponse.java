package com.example.practica4.models;

import java.util.List;

public class MessageResponse {
    public boolean ok ;
    public List<Messages> messages;

    public MessageResponse(Boolean ok, Messages messages) {
    }

    public MessageResponse() {

    }
}
