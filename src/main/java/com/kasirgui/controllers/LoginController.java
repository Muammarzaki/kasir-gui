package com.kasirgui.controllers;

import java.io.IOException;

import com.kasirgui.App;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class LoginController {

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
            if ("ayam".equals(pass_d.getText().trim())) {
                System.out.println("success");
                App.setRoot("buy");
            } else {
                pass_d.setStyle(String.format("-fx-border-color: RED; -fx-border-width: 2;-fx-border-radius: 5;"));
            }
            pass_d.clear();
        }
    }
}
