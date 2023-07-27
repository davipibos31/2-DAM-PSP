module com.example.ejercicio8 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.ejercicio8 to javafx.fxml;
    exports com.example.ejercicio8;
}