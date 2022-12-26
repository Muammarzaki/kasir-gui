package com.kasirgui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class PayDialogController implements Initializable {

    @FXML
    public TextField payField;

    @FXML
    public TextField returnField;

    @FXML
    public TextField total;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        payField.setOnKeyReleased(new EventHandler<Event>() {

            @Override
            public void handle(Event arg0) {
                String regex = "[rp.,RP]";
                try {
                    if (!payField.getText().isEmpty()) {
                        int payfieldInt = Integer.parseInt(payField.getText().replaceAll(regex, "").trim());
                        int totalFieldInt = Integer.parseInt(total.getText().replaceAll(regex, "").trim());
                        Integer sisa = payfieldInt
                                - totalFieldInt;
                        if (payfieldInt >= totalFieldInt) {

                            returnField.setText(String.format("Rp. %,d", sisa));

                        } else {
                            returnField.clear();
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        });
    }

}
