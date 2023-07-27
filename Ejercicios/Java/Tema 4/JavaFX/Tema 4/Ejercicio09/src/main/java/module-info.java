module com.example.ejercicio09 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.ejercicio09 to javafx.fxml;
    exports com.example.ejercicio09;
}