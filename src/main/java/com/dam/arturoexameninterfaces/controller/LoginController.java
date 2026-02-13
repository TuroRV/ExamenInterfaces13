package com.dam.arturoexameninterfaces.controller;

import com.dam.arturoexameninterfaces.DAO.UsuarioDAO;
import com.dam.arturoexameninterfaces.model.Usuario;
import com.dam.arturoexameninterfaces.util.Alertas;
import com.dam.arturoexameninterfaces.util.AppShell;
import com.dam.arturoexameninterfaces.util.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {
    @FXML
    public TextField nombreUsuarioTF;
    @FXML
    public PasswordField contrasenaUsuarioTF;
    @FXML
    public Button loginBTN;
    @FXML
    public Button registroBTN;

    UsuarioDAO usuarioDAO = new UsuarioDAO();

    public boolean comprobarCampos(){
        return !(nombreUsuarioTF.getText().isEmpty() && !contrasenaUsuarioTF.getText().isEmpty());
    }


    public void handleLogin(ActionEvent actionEvent) {
        if (comprobarCampos()){
            String nombre = nombreUsuarioTF.getText();
            String contrasena = contrasenaUsuarioTF.getText();
            Usuario usuarioALoguear = usuarioDAO.login(nombre, contrasena);
            if (usuarioALoguear != null) {
                Alertas.showStandardAlert("Éxito","Login realizado con éxito", Alert.AlertType.INFORMATION);
                AppShell.getInstance().setUsuario(usuarioALoguear);
                AppShell.getInstance().changeView(View.HOME);
            }
        }
        else {
            Alertas.showStandardAlert("Error","Rellena los cammpos", Alert.AlertType.ERROR);
        }

    }

    public void handleRegistro(ActionEvent actionEvent) {
        AppShell.getInstance().changeView(View.REGISTER);
    }
}
