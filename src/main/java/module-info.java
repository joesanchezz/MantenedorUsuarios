module com.sanchez.jorge {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.sanchez.jorge to javafx.fxml;
    exports com.sanchez.jorge.controller;
    opens com.sanchez.jorge.controller to javafx.fxml;
    exports com.sanchez.jorge;
    opens com.sanchez.jorge.dto to javafx.base;
}