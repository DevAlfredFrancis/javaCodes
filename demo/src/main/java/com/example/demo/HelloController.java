/**
 * Ramos, Alfred Francis
 * Nov. 7, 2025
 * Profile Card Implementation
 */


package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {

    @FXML
    private ImageView imageView;

    @FXML
    private Button changeButton;

    @FXML
    private Label welcomeText;

    private String[] images = {
            "/images/image1.jpg",
            "/images/image2.jpg",
            "/images/image3.jpg",
            "/images/image4.png"
    };

    private int currentIndex = 0;

    @FXML
    public void initialize() {
        // Load the first image when the app starts
        imageView.setImage(new Image(getClass().getResourceAsStream(images[currentIndex])));
    }

    @FXML
    private void handleChangeImage() {
        // Move to the next image (looping back to start)
        currentIndex = (currentIndex + 1) % images.length;
        imageView.setImage(new Image(getClass().getResourceAsStream(images[currentIndex])));
    }


}