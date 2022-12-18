package com.kasirgui.controllers;

import java.io.IOException;
import java.util.Properties;

import com.kasirgui.App;
import com.kasirgui.helpers.PropertiesConfig;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class LoginController {
    private Properties config = PropertiesConfig.getConfig("config");
    private String usernameConfig = config.getProperty("login.username");
    private String passwordConfig = config.getProperty("login.password");
    @FXML
    private BorderPane parentPane;

    @FXML
    private PasswordField pass_d;

    @FXML
    private TextField username;

    @FXML
    void checkPassword(KeyEvent event) throws IOException {
        pass_d.setStyle(null);
        if (event.getCode() == KeyCode.ENTER) {
            if (usernameConfig.equals(username.getText().trim()) &&
                    passwordConfig.equals(pass_d.getText().trim())) {
                App.setRoot("buy");
            } else {
                pass_d.setStyle("-fx-border-color: RED; -fx-border-width:2;-fx-border-radius: 5;");
                username.setStyle("-fx-border-color: RED; -fx-border-width:2;-fx-border-radius: 5;");
            }
            username.clear();
            pass_d.clear();
        }
    }
}
