package com.example.luxeauraapp.controllers;

import com.example.luxeauraapp.models.SalonServicesModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EditServiceController {
    @FXML private TextField serviceNameField;
    @FXML private TextField categoryField;
    @FXML private TextArea descriptionField;
    @FXML private TextField durationField;
    @FXML private TextField priceField;
    @FXML private Button btnSave;
    @FXML private Button btnCancel;

    private SalonServicesModel service;  // the service to edit

    public void setService(SalonServicesModel service) {
        this.service = service;

        // populate fields
        serviceNameField.setText(service.getServiceName());
        categoryField.setText(service.getServiceCategory());
        descriptionField.setText(service.getDescription());
        durationField.setText(String.valueOf(service.getServiceDuration()));
        priceField.setText(String.valueOf(service.getServicePrice()));
    }

    @FXML
    private void saveChanges() {
        try {
            // update service model
            service.setServiceName(serviceNameField.getText());
            service.setServiceCategory(categoryField.getText());
            service.setDescription(descriptionField.getText());
            service.setServiceDuration(Integer.parseInt(durationField.getText()));
            service.setServicePrice(Double.parseDouble(priceField.getText()));

            // Update database
            updateDatabase(service);

            // close modal
            Stage stage = (Stage) btnSave.getScene().getWindow();
            stage.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Service updated successfully!");
            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateDatabase(SalonServicesModel service) {
        String query = "UPDATE services SET services_name=?, category=?, description=?, duration_minutes=?, price=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/luxe_db", "root", "");
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, service.getServiceName());
            stmt.setString(2, service.getServiceCategory());
            stmt.setString(3, service.getDescription());
            stmt.setInt(4, service.getServiceDuration());
            stmt.setDouble(5, service.getServicePrice());
            stmt.setInt(6, service.getId());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cancel() {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
