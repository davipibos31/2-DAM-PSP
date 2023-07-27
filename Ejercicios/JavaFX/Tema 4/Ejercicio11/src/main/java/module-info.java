module com.example.ejercicio11 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.ejercicio11 to javafx.fxml;
    exports com.example.ejercicio11;
}