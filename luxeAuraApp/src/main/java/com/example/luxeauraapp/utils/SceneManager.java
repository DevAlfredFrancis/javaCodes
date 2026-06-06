package com.example.luxeauraapp.utils;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class SceneManager {

    private static Stage primaryStage;

    public static void setStage(Stage stage) {
        primaryStage = stage;

        // Set screen size once (taskbar visible)
        Rectangle2D vb = Screen.getPrimary().getVisualBounds();

        primaryStage.setX(vb.getMinX());
        primaryStage.setY(vb.getMinY());
        primaryStage.setWidth(vb.getWidth());
        primaryStage.setHeight(vb.getHeight());
    }

    public static void switchScene(String fxmlName) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    SceneManager.class.getResource("/com/example/luxeauraapp/" + fxmlName)
            );

            Scene scene = new Scene(loader.load());

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
