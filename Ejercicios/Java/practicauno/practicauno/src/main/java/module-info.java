module com.example.practicauno {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.practicauno to javafx.fxml;
    exports com.example.practicauno;
    exports com.example.practicauno.model;
    exports com.example.practicauno.utils;
}