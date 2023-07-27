package com.example.practica4.register;

public class RegisterRequest {
    public String name;
    public String password;
    public String image;

    public RegisterRequest(String name, String password, String image) {
        this.name = name;
        this.password = password;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
