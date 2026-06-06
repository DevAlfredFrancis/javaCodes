module com.example.luxeauraapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires javafx.graphics;
    requires java.sql;
    requires de.jensd.fx.glyphs.fontawesome;
    requires javafx.base;
    requires java.desktop;

    opens com.example.luxeauraapp.models to javafx.base;
    opens com.example.luxeauraapp to javafx.fxml;
    exports com.example.luxeauraapp;
    exports com.example.luxeauraapp.controllers;
    opens com.example.luxeauraapp.controllers to javafx.fxml;
    exports com.example.luxeauraapp.utils;
    opens com.example.luxeauraapp.utils to javafx.fxml;
}