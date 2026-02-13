package com.dam.arturoexameninterfaces.util;

import com.dam.arturoexameninterfaces.model.Usuario;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppShell {

    private static AppShell instance;
    private Stage stage;
    private Usuario usuario;

    public static AppShell getInstance() {
        if (instance == null) {
            instance = new AppShell();
        }
        return instance;
    }

    public void changeView(View view) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(view.getFxmlpath()));
            Parent root = loader.load();

            Scene scene = new Scene(root,800,600);
            stage.setScene(scene);
            stage.setTitle(view.getTitulo());
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error changeview");
        }
    }

    private AppShell() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
