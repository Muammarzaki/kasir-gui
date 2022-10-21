package com.kasirgui.controllers;

import java.io.IOException;

import com.kasirgui.App;

import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
