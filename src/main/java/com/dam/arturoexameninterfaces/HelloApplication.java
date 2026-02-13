package com.dam.arturoexameninterfaces;

import com.dam.arturoexameninterfaces.util.AppShell;
import com.dam.arturoexameninterfaces.util.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AppShell.getInstance().setStage(stage);
        AppShell.getInstance().changeView(View.LOGIN);
    }
}
