package com.example.practica4.register;

import com.example.practica4.models.Users;

public class RegisterResponse extends Users {
    public Users users;

    public RegisterResponse(Users users) {
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
