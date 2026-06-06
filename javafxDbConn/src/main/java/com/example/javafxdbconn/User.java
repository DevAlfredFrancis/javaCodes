package com.example.javafxdbconn;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty email;

    public User(int id, String name, String email) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);

    }

    public int getId() { return id.get(); }
    public String getName() {
        return name.get();
    }
    public String getEmail() {
        return email.get();
    }


    // SETTERS
    public void setName(String name) {
        this.name.set(name);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }


}
