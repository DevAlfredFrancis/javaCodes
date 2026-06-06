package com.example.luxeauraapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BaseSidebarController {

    @FXML protected Button btnDashboard;
    @FXML protected Button btnServices;
    @FXML protected Button btnBookings;
    @FXML protected Button btnCustomers;
    @FXML protected Button btnSales;

    public void initSidebar(String active) {

        Button[] buttons = {
                btnDashboard, btnServices, btnBookings, btnCustomers, btnSales
        };

        String[] icons = {
                "HOME", "SCISSORS", "CALENDAR", "USERS", "LINE_CHART"
        };

        // Reset all buttons
        for (int i = 0; i < buttons.length; i++) {
            Button btn = buttons[i];

            // Always keep the outlined style
            if (!btn.getStyleClass().contains("button-transparent")) {
                btn.getStyleClass().add("button-transparent");
            }

            // Remove active highlight
            btn.getStyleClass().remove("active");

        }

        // Highlight the active button
        switch (active) {
            case "dashboard" -> btnDashboard.getStyleClass().add("active");
            case "services" -> btnServices.getStyleClass().add("active");
            case "bookings" -> btnBookings.getStyleClass().add("active");
            case "customers" -> btnCustomers.getStyleClass().add("active");
            case "sales" -> btnSales.getStyleClass().add("active");
        }
    }
}
