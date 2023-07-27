module com.example.practica1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.practica1 to javafx.fxml;
}