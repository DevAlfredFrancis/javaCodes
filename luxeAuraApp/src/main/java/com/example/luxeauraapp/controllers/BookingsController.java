package com.example.luxeauraapp.controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import com.example.luxeauraapp.models.BookingModel;
import com.example.luxeauraapp.utils.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class BookingsController extends BaseSidebarController implements Initializable {

    @FXML private TableView<BookingModel> bookingsTable;
    @FXML private TableColumn<BookingModel, String> colBookingRef;
    @FXML private TableColumn<BookingModel, String> colDateTime;
    @FXML private TableColumn<BookingModel, String> colCustomer;
    @FXML private TableColumn<BookingModel, String> colServices;
    @FXML private TableColumn<BookingModel, Double> colPrice;
    @FXML private TableColumn<BookingModel, String> colContact;
    @FXML private TableColumn<BookingModel, String> colStatus;
    @FXML private TableColumn<BookingModel, Void> actionsColumn;

    private ObservableList<BookingModel> bookingModelList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Highlight sidebar button automatically
        initSidebar("bookings");

        loadColumns();
        loadDataFromDB();
        addActionButtons();
    }

    private void loadColumns() {
        colBookingRef.setCellValueFactory(new PropertyValueFactory<>("bookingReference"));
        colDateTime.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
        colCustomer.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colServices.setCellValueFactory(new PropertyValueFactory<>("services"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    //fetch data from database
    private void loadDataFromDB() {
        bookingModelList.clear();

        String query = "SELECT id, booking_reference, CONCAT(first_name, ' ' , last_name ) AS customer_name, appointment_datetime, services, total_price, mobile_number, status FROM bookings";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/luxe_db", "root", "");
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                BookingModel bookingModel = new BookingModel(
                        rs.getInt("id"),
                        rs.getString("booking_reference"),
                        rs.getString("appointment_datetime"),
                        rs.getString("customer_name"),
                        rs.getString("services"),
                        rs.getDouble("total_price"),
                        rs.getString("mobile_number"),
                        rs.getString("status")
                );

                bookingModelList.add(bookingModel);
            }

            bookingsTable.setItems(bookingModelList);

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
                    BookingModel bookingModel = getTableView().getItems().get(getIndex());
                    System.out.println("Edit: " + bookingModel.getBookingReference());
                    // TODO: show edit popup
                });

                deleteIcon.setOnMouseClicked(e -> {
                    BookingModel bookingModel = getTableView().getItems().get(getIndex());
                    System.out.println("Delete: " + bookingModel.getBookingReference());
                    // TODO: delete popup
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


    //method for buttons
    @FXML
    private void showDashboard() throws IOException {
        SceneManager.switchScene("dashboard.fxml");
    }

    @FXML
    private void showSalonServices() throws IOException {
        SceneManager.switchScene("SalonServices.fxml");
    }
}
