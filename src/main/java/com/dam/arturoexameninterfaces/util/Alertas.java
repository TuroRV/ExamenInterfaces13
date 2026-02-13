package com.dam.arturoexameninterfaces.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Alertas {

    public static void showStandardAlert(String titulo, String texto, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(texto);
        alert.showAndWait();
    }

    public static boolean showConfirmationAlert(String titulo, String texto){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setContentText(texto);
        alert.showAndWait();
        return alert.getResult() == ButtonType.OK;
    }
}
