package com.example.httpservice;

public class Users {
    public String nombre;
    public String contrasenya;
    public String image;

    public Users(String nombre, String contrasenya, String image) {
        this.nombre = nombre;
        this.contrasenya = contrasenya;
        this.image = image;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
