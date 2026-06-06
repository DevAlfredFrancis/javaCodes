package com.example.luxeauraapp.controllers;

import javafx.fxml.FXML;
import com.example.luxeauraapp.utils.SceneManager;

import java.io.IOException;

public class DashboardController extends BaseSidebarController {

    public void initialize() {
        // Highlight sidebar button automatically
        initSidebar("dashboard");
    }

    //method for buttons
    @FXML
    public void showDashboard() throws IOException {
        SceneManager.switchScene("dashboard.fxml");
    }

    @FXML
    public void showBookings() throws IOException {
        SceneManager.switchScene("bookings.fxml");
    }

    @FXML
    public void showSalonServices() throws IOException {
        SceneManager.switchScene("SalonServices.fxml");
    }

}
