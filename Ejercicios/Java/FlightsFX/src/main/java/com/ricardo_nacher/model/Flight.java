package com.ricardo_nacher.model;

import com.ricardo_nacher.flightsfx.HelloController;
import com.ricardo_nacher.utils.FileUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Flight extends FileUtils {

    private String num_vuelo;
    private String nom_ciudad;
    private LocalDateTime fechasalida_horasalida;
    private LocalTime duracion_vuelo;


    public Flight(String num_vuelo, String nom_ciudad, LocalDateTime fechasalida_horasalida, LocalTime duracion_vuelo) {
        this.num_vuelo = num_vuelo;
        this.nom_ciudad = nom_ciudad;
        this.fechasalida_horasalida =  fechasalida_horasalida;
        this.duracion_vuelo = duracion_vuelo;
    }

    public Flight(String num_vuelo) {
        this.num_vuelo = num_vuelo;

    }



    public String getNum_vuelo() {
        return num_vuelo;
    }

    public String getNom_ciudad() {
        return nom_ciudad;
    }

    public LocalDateTime getFechasalida_horasalida() {
        return fechasalida_horasalida;
    }

    public LocalTime getDuracion_vuelo() {
        return duracion_vuelo;
    }

    public void setNum_vuelo(String num_vuelo) {
        this.num_vuelo = num_vuelo;
    }

    public void setNom_ciudad(String nom_ciudad) {
        this.nom_ciudad = nom_ciudad;
    }

    public void setFechasalida_horasalida(LocalDateTime fechasalida_horasalida) {
        this.fechasalida_horasalida = fechasalida_horasalida;
    }

    public void setDuracion_vuelo(LocalTime duracion_vuelo) {
        this.duracion_vuelo = duracion_vuelo;
    }
}
