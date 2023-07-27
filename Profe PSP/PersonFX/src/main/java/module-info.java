module com.jmcompany.personfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.jmcompany.personfx to javafx.fxml;
    exports com.jmcompany.personfx;
    exports com.jmcompany.personfx.model.person;
}