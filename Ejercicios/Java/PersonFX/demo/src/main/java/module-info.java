module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.model.person;
    exports com.example.demo.model;
}