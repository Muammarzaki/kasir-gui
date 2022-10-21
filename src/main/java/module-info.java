module com.kasirgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires transitive javafx.graphics;
    // opens com.kasirgui to javafx.fxml;

    opens com.kasirgui.controllers to javafx.fxml;
    opens com.kasirgui.model to javafx.base;

    exports com.kasirgui;

    // exports com.kasirgui.controllers;
}
