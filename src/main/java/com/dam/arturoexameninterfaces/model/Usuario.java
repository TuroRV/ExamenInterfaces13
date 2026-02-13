package com.dam.arturoexameninterfaces.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    private String username;
    private String password;
    private boolean isAdmin;

    public Usuario(){}

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        this.isAdmin = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
