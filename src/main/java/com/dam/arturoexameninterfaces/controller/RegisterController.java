package com.dam.arturoexameninterfaces.controller;

import com.dam.arturoexameninterfaces.DAO.UsuarioDAO;
import com.dam.arturoexameninterfaces.model.Usuario;
import com.dam.arturoexameninterfaces.util.Alertas;
import com.dam.arturoexameninterfaces.util.AppShell;
import com.dam.arturoexameninterfaces.util.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {
    @FXML
    public TextField nombreTF;
    @FXML
    public PasswordField contrasenaTF;
    @FXML
    public Button registerBTN;
    @FXML
    public Button volverBTN;

    UsuarioDAO usuarioDAO = new UsuarioDAO();

    public boolean comprobarCampos(){
        return !(nombreTF.getText().isEmpty() && !contrasenaTF.getText().isEmpty());
    }

    public void handleRegistro(ActionEvent actionEvent) {
        if(comprobarCampos()){
            Usuario usuario = new Usuario(nombreTF.getText(), contrasenaTF.getText());
            if (usuarioDAO.registro(usuario)) {
                Alertas.showStandardAlert("Éxito","Usuario registrado con éxito, será redirigido al login", Alert.AlertType.INFORMATION);
                AppShell.getInstance().changeView(View.LOGIN);
            }
            else {
                Alertas.showStandardAlert("Error","Error en registro o usuario ya existe", Alert.AlertType.ERROR);
            }

        }
        else
        {
            Alertas.showStandardAlert("Error","Rellena los campos", Alert.AlertType.ERROR);
        }
    }

    public void handleVolver(ActionEvent actionEvent) {
        AppShell.getInstance().changeView(View.LOGIN);
    }
}
