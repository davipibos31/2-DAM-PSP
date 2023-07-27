module com.example.practica4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.google.gson;

    opens com.example.practica4 to javafx.fxml;
    exports com.example.practica4;
    exports com.example.practica4.http;
    opens com.example.practica4.http to javafx.fxml;
    exports com.example.practica4.login;
    opens com.example.practica4.login to javafx.fxml;
    exports com.example.practica4.service;
    exports com.example.practica4.models;

    exports com.example.practica4.register;
}