package com.example.luxeauraapp.controllers;

import com.example.luxeauraapp.models.SalonServicesModel;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import com.example.luxeauraapp.utils.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class SalonServicesController extends BaseSidebarController implements Initializable {

    @FXML private TableView<SalonServicesModel> servicesTable;
    @FXML private TableColumn<SalonServicesModel, String> colServiceName;
    @FXML private TableColumn<SalonServicesModel, String> colCategory;
    @FXML private TableColumn<SalonServicesModel, String> colDescription;
    @FXML private TableColumn<SalonServicesModel, Integer> colDuration;
    @FXML private TableColumn<SalonServicesModel, Double> colPrice;
    @FXML private TableColumn<SalonServicesModel, Void> actionsColumn;

    private ObservableList<SalonServicesModel> servicesList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Highlight sidebar button automatically
        initSidebar("services");

        loadColumns();
        loadDataFromDB();
        addActionButtons();
    }

    //load data
    private void loadColumns() {
        colServiceName.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("serviceCategory"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("serviceDuration"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("servicePrice"));
    }

    //fetch data from database
    private void loadDataFromDB() {
        servicesList.clear();

        String query = "SELECT id, services_name, category, description, duration_minutes, price FROM services";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/luxe_db", "root", "");
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                SalonServicesModel services = new SalonServicesModel(
                        rs.getInt("id"),
                        rs.getString("services_name"),
                        rs.getString("category"),
                        rs.getString("description"),
                        rs.getInt("duration_minutes"),
                        rs.getDouble("price")
                );

                servicesList.add(services);
            }

            servicesTable.setItems(servicesList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //add button for edit and delete
    private void addActionButtons() {
        actionsColumn.setCellFactory(col -> new TableCell<>() {

            private final FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL);
            private final FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);

            {
                editIcon.setStyle("-fx-fill: #3498db; -fx-cursor: hand;");   // blue
                editIcon.setGlyphSize(18);

                deleteIcon.setStyle("-fx-fill: #e74c3c; -fx-cursor: hand;"); // red
                deleteIcon.setGlyphSize(18);

                editIcon.setOnMouseClicked(e -> {
                    SalonServicesModel salonServicesModel = getTableView().getItems().get(getIndex());
                    openEditModal(salonServicesModel);
                });

                deleteIcon.setOnMouseClicked(e -> {
                    SalonServicesModel salonServicesModel = getTableView().getItems().get(getIndex());
                    openDeleteConfirmation(salonServicesModel);
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else {
                    HBox box = new HBox(15, editIcon, deleteIcon);
                    box.setAlignment(Pos.CENTER);
                    setGraphic(box);
                }
            }
        });
    }

    //open modal for editing data
    private void openEditModal(SalonServicesModel service) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/luxeauraapp/editService.fxml"));
            Parent root = loader.load();

            EditServiceController controller = loader.getController();
            controller.setService(service);

            Stage stage = new Stage();
            stage.setTitle("Edit Service");
            stage.setScene(new Scene(root));
            stage.setResizable(false);

            stage.initStyle(StageStyle.UNDECORATED);

            // Make it a true modal
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.setOnShown(e -> {
                Stage parent = (Stage) servicesTable.getScene().getWindow(); // any node from parent scene
                stage.setX(parent.getX() + (parent.getWidth() - stage.getWidth()) / 2);
                stage.setY(parent.getY() + (parent.getHeight() - stage.getHeight()) / 2);
            });

            // Wait until modal closes
            stage.showAndWait();

            // Refresh table after editing
            servicesTable.refresh();

        } catch (Exception ex) {
            ex.printStackTrace();
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText(null);
            error.setContentText("Failed to open Edit Service modal.");
            error.showAndWait();
        }
    }

    //confirmation to delete service
    private void openDeleteConfirmation(SalonServicesModel service) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Service");
        alert.setHeaderText("Are you sure?");
        alert.setContentText("This will permanently delete: " + service.getServiceName());

        ButtonType yes = new ButtonType("Delete");
        ButtonType no = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(yes, no);

        alert.showAndWait().ifPresent(type -> {
            if (type == yes) {
                deleteService(service);
            }
        });
    }

    //delete service
    private void deleteService(SalonServicesModel service) {
        String sql = "DELETE FROM services WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/luxe_db", "root", "");
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, service.getId());

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                servicesList.remove(service); // remove from table observable list
                servicesTable.refresh();

                // Optional simple alert
                Alert success = new Alert(Alert.AlertType.INFORMATION);
                success.setTitle("Deleted");
                success.setHeaderText(null);
                success.setContentText("Service deleted successfully!");
                success.showAndWait();
            }

        } catch (Exception e) {
            e.printStackTrace();
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText(null);
            error.setContentText("Error deleting service!");
            error.showAndWait();
        }
    }

    //open service modal
    @FXML
    private void openAddServiceModal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/luxeauraapp/addService.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Add New Service");
            stage.setScene(new Scene(root));
            stage.setResizable(false);

            // Remove OS window buttons
            stage.initStyle(StageStyle.UNDECORATED);

            stage.setOnShown(e -> {
                Stage parent = (Stage) servicesTable.getScene().getWindow(); // any node from parent scene
                stage.setX(parent.getX() + (parent.getWidth() - stage.getWidth()) / 2);
                stage.setY(parent.getY() + (parent.getHeight() - stage.getHeight()) / 2);
            });

            // Make it a true modal
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.showAndWait();

            // Refresh table after modal closes
            loadDataFromDB();

        } catch (IOException e) {
            e.printStackTrace();
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText(null);
            error.setContentText("Failed to open Add Service modal.");
            error.showAndWait();
        }
    }

    //add service to the database
    void addService(SalonServicesModel service) {
        String sql = "INSERT INTO services (services_name, category, description, duration_minutes, price) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/luxe_db", "root", "");
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, service.getServiceName());
            stmt.setString(2, service.getServiceCategory());
            stmt.setString(3, service.getDescription());
            stmt.setInt(4, service.getServiceDuration());
            stmt.setDouble(5, service.getServicePrice());

            stmt.executeUpdate();

            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Success");
            success.setHeaderText(null);
            success.setContentText("Service added successfully!");
            success.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText(null);
            error.setContentText("Failed to add service.");
            error.showAndWait();
        }
    }

    //methods for buttons
    @FXML
    public void showDashboard() throws IOException {
        SceneManager.switchScene("dashboard.fxml");
    }

    @FXML
    public void showBookings() throws IOException {
        SceneManager.switchScene("bookings.fxml");
    }
}
