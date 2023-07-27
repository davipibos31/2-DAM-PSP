package com.example.httpservice.login;

public class LoginResponse {
    public String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginResponse(String token) {
        this.token = token;
    }
}
