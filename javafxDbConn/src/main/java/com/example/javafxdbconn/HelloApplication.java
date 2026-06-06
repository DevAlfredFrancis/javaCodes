package com.example.javafxdbconn;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class HelloApplication extends Application {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/user";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    private ObservableList<User> data;
    private TableView<User> table;

    @Override
    public void start(Stage primaryStage) {

        table = new TableView<>();

        TableColumn<User, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setMinWidth(150);

        TableColumn<User, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        emailCol.setMinWidth(200);

        table.getColumns().addAll(nameCol, emailCol);

        data = fetchDataFromDB();
        table.setItems(data);

        HBox inputBox = getInputControls();

        VBox layout = new VBox(10, table, inputBox);
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout, 550, 450);
        primaryStage.setTitle("JavaFX - CRUD Users");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox getInputControls() {

        TextField nameInput = new TextField();
        nameInput.setPromptText("Name");

        TextField emailInput = new TextField();
        emailInput.setPromptText("Email");

        Button addButton = new Button("Add");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");

        // Fill inputs when a row is clicked
        table.setOnMouseClicked(event -> {
            User selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                nameInput.setText(selected.getName());
                emailInput.setText(selected.getEmail());
            }
        });

        // ADD BUTTON
        addButton.setOnAction(e -> {
            String name = nameInput.getText();
            String email = emailInput.getText();

            if (name.isEmpty() || email.isEmpty()) {
                showAlert("Error", "Please fill in both fields.");
                return;
            }

            if (insertUserToDB(name, email)) {
                nameInput.clear();
                emailInput.clear();
            }
        });

        // UPDATE BUTTON
        updateButton.setOnAction(e -> {
            User selected = table.getSelectionModel().getSelectedItem();

            if (selected == null) {
                showAlert("Error", "Please select a user to update.");
                return;
            }

            String newName = nameInput.getText();
            String newEmail = emailInput.getText();

            if (newName.isEmpty() || newEmail.isEmpty()) {
                showAlert("Error", "Fields cannot be empty.");
                return;
            }

            if (updateUserInDB(selected, newName, newEmail)) {
                selected.setName(newName);
                selected.setEmail(newEmail);
                table.refresh();
                nameInput.clear();
                emailInput.clear();
            }
        });

        // DELETE BUTTON
        deleteButton.setOnAction(e -> {
            User selected = table.getSelectionModel().getSelectedItem();

            if (selected == null) {
                showAlert("Error", "Please select a user to delete.");
                return;
            }

            if (deleteUserFromDB(selected.getId())) {
                data.remove(selected);
                nameInput.clear();
                emailInput.clear();
            }
        });

        HBox box = new HBox(10, nameInput, emailInput, addButton, updateButton, deleteButton);
        box.setPadding(new Insets(10));
        return box;
    }

    // INSERT
    private boolean insertUserToDB(String name, String email) {
        String query = "INSERT INTO users (name, email) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                data.add(new User(id, name, email)); // add here only
            }

            return true;

        } catch (Exception e) {
            showAlert("Database Error", e.getMessage());
            return false;
        }
    }

    // UPDATE
    private boolean updateUserInDB(User user, String newName, String newEmail) {
        String query = "UPDATE users SET name=?, email=? WHERE id=?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, newName);
            stmt.setString(2, newEmail);
            stmt.setInt(3, user.getId());

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            showAlert("Update Failed", e.getMessage());
            return false;
        }
    }


    // DELETE
    private boolean deleteUserFromDB(int id) {
        String query = "DELETE FROM users WHERE id=?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            showAlert("Delete Failed", e.getMessage());
            return false;
        }
    }


    // LOAD
    private ObservableList<User> fetchDataFromDB() {
        ObservableList<User> users = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id , name, email FROM users")) {

            while (rs.next()) {
                users.add(new User(rs.getInt("id"),rs.getString("name"), rs.getString("email")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    private void showAlert(String t, String m) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(t);
        a.setContentText(m);
        a.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
