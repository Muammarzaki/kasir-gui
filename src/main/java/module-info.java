module com.kasirgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires transitive javafx.graphics;
    requires com.fasterxml.jackson.databind;

    /**
     * opens com.kasirgui to javafx.fxml;
     * 
     */
    opens com.kasirgui.controllers to javafx.fxml;
    opens com.kasirgui.model to javafx.base;

    /**
     * exports com.kasirgui.controllers;
     * 
     */
    exports com.kasirgui;

}
