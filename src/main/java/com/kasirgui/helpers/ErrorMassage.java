package com.kasirgui.helpers;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class ErrorMassage extends Pane {
    Label labelmassage = new Label();

    public ErrorMassage(String massage) {
        labelmassage.setText(massage);
    }

}
