module com.example.flightsfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.ricardo_nacher.flightsfx to javafx.fxml;
    exports com.ricardo_nacher.flightsfx;
    exports com.ricardo_nacher.model;
}