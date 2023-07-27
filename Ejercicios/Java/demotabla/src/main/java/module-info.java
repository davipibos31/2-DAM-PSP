module com.example.demotabla {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.demotabla to javafx.fxml;
    exports com.example.demotabla;
}