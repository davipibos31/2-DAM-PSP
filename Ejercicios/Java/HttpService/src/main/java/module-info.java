module com.example.httpservice {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.google.gson;

    opens com.example.httpservice to javafx.fxml;
    exports com.example.httpservice;
    exports com.example.httpservice.service;
    exports com.example.httpservice.utils;
    exports com.example.httpservice.login;
}