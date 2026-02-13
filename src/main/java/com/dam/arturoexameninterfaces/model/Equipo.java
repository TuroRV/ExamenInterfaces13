package com.dam.arturoexameninterfaces.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private boolean campeon;
    private LocalDate fecha_fundacion;
    private String foto_url;

    public Equipo(){}

    public Equipo(String nombre, boolean campeon, LocalDate fecha_fundacion, String foto_url) {
        this.nombre = nombre;
        this.campeon = campeon;
        this.fecha_fundacion = fecha_fundacion;
        this.foto_url = foto_url;
    }

    public Equipo(int id, String nombre, boolean campeon, LocalDate fecha_fundacion, String foto_url) {
        this.id = id;
        this.nombre = nombre;
        this.campeon = campeon;
        this.fecha_fundacion = fecha_fundacion;
        this.foto_url = foto_url;
    }

    public Equipo(String nombre, boolean campeon, LocalDate fecha_fundacion) {
        this.nombre = nombre;
        this.campeon = campeon;
        this.fecha_fundacion = fecha_fundacion;
    }

    public Equipo(int id, String nombre, boolean campeon, LocalDate fecha_fundacion) {
        this.id = id;
        this.nombre = nombre;
        this.campeon = campeon;
        this.fecha_fundacion = fecha_fundacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isCampeon() {
        return campeon;
    }

    public void setCampeon(boolean campeon) {
        this.campeon = campeon;
    }

    public LocalDate getFecha_fundacion() {
        return fecha_fundacion;
    }

    public void setFecha_fundacion(LocalDate fecha_fundacion) {
        this.fecha_fundacion = fecha_fundacion;
    }

    public String getFoto_url() {
        return foto_url;
    }

    public void setFoto_url(String foto_url) {
        this.foto_url = foto_url;
    }
}
