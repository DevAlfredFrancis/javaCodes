package com.example.luxeauraapp.controllers;

import com.example.luxeauraapp.models.SalonServicesModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddServiceController {
    @FXML private TextField serviceNameField;
    @FXML private TextField categoryField;
    @FXML private TextArea descriptionField;
    @FXML private TextField durationField;
    @FXML private TextField priceField;
    @FXML private Button btnSave;
    @FXML private Button btnCancel;

    private SalonServicesController parentController;

    public void setParentController(SalonServicesController controller) {
        this.parentController = controller;
    }

    @FXML
    private void saveService() {
        try {
            SalonServicesModel service = new SalonServicesModel(
                    0,
                    serviceNameField.getText(),
                    categoryField.getText(),
                    descriptionField.getText(),
                    Integer.parseInt(durationField.getText()),
                    Double.parseDouble(priceField.getText())
            );

            parentController.addService(service);

            Stage stage = (Stage) btnSave.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
            //showError("Invalid input. Please check all fields.");
        }
    }



    @FXML
    private void cancel() {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
