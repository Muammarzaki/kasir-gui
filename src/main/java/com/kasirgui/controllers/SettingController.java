package com.kasirgui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import com.kasirgui.App;
import com.kasirgui.helpers.PropertiesConfig;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class SettingController implements Initializable {
    Properties config = PropertiesConfig.getConfig("config");
    @FXML
    private TextField dataField;

    @FXML
    private Button applyPasswordButton;

    @FXML
    private Button applyUsernameButton;

    @FXML
    private TextField auditField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button createAuditButton;

    @FXML
    private Button createDataButton;

    @FXML
    private TextField userNameField;

    @FXML
    private AnchorPane buyPane;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String username = config.getProperty("login.username");
        userNameField.setText(username);
        String password = config.getProperty("login.password");
        passwordField.setText(password);
        buyPane.setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event arg0) {
                try {
                    App.setRoot("buy");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        applyUsernameButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                try {

                    config.setProperty("login.username", userNameField.getText());
                    popup();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        applyPasswordButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                try {
                    config.setProperty("login.password", passwordField.getText());
                    popup();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        createAuditButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub

            }

        });

        createDataButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub

            }

        });
    }

    void popup() {
        Alert popup = new Alert(AlertType.INFORMATION);
        popup.setContentText("setting has been change");
        popup.show();
    }
}
