package com.example.practicauno.model;

import com.example.practicauno.utils.FileUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;



@SuppressWarnings("unused")
public class Fight extends FileUtils {
    public Fight(String numvul, String lugar, LocalDateTime fecha, LocalTime duracion) {
        this.numvul = numvul;
        this.lugar = lugar;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public Fight(String numvul) { this.numvul = numvul;}

    @SuppressWarnings("FieldMayBeFinal")
    private String numvul;
    private String lugar;
    private LocalDateTime fecha;
    private LocalTime duracion;

    public String getNumvul() {
        return numvul;
    }

    public void setNumvul(String numvul) {this.numvul = numvul;}

    public String getLugar() {return lugar;}

    public void setLugar(String lugar) {this.lugar = lugar;}

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {this.fecha = fecha;}

    public LocalTime getDuracion() {
        return duracion;
    }

    public void setDuracion(LocalTime duracion) {this.duracion = duracion;}
    @Override
    public String toString() {
        return numvul + ';' + lugar +  ';' + fecha + ';' + duracion;
    }
}
