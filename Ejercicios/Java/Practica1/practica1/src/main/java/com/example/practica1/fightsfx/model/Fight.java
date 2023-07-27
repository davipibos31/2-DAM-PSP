package com.example.practica1.fightsfx.model;

import com.example.practica1.fightsfx.utils.FileUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Fight extends FileUtils {
    private String numvue;
    private String nombre;
    private LocalDateTime horafecha;
    private LocalTime duracion;

    public Fight(String numvue) {
        this.numvue = numvue;
    }

    public Fight(String numvue, String nombre, LocalDateTime horafecha, LocalTime duracion) {
        this.numvue = numvue;
        this.nombre = nombre;
        this.horafecha = horafecha;
        this.duracion = duracion;
    }

    public String getNumvue() {
        return numvue;
    }

    public void setNumvue(String numvue) {
        this.numvue = numvue;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getHorafecha() {
        return horafecha;
    }

    public void setHorafecha(LocalDateTime horafecha) {
        this.horafecha = horafecha;
    }

    public LocalTime getDuracion() {
        return duracion;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }
}
