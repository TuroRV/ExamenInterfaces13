package com.dam.arturoexameninterfaces.util;

public enum View {
    LOGIN("/com/dam/arturoexameninterfaces/login-view.fxml","Login"),
    HOME("/com/dam/arturoexameninterfaces/home-view.fxml","Home"),
    REGISTER("/com/dam/arturoexameninterfaces/register-view.fxml","Registro"),;

    private String fxmlpath;
    private String titulo;

    View(String fxmlpath, String titulo) {
        this.fxmlpath = fxmlpath;
        this.titulo = titulo;
    }

    public String getFxmlpath() {

        return fxmlpath;

    }

    public String getTitulo() {
        return titulo;
    }

}
