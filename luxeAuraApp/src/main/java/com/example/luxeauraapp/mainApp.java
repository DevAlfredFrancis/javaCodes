package com.example.luxeauraapp;

import com.example.luxeauraapp.utils.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class mainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        SceneManager.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(mainApp.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("LuxeAura Management System");
        stage.setScene(scene);
        stage.show();
    }
}
