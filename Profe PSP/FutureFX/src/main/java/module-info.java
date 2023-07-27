module com.example.futurefx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.futurefx to javafx.fxml;
    exports com.example.futurefx;
    exports com.example.futurefx.model;
}