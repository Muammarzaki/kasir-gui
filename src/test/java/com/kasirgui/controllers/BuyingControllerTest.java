package com.kasirgui.controllers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BuyingControllerTest {

    @Test
    void singletonRegularListandObser() {
        List<String> ra = new ArrayList<>();
        ObservableList<String> bean = FXCollections.observableList(ra);
        ra.add("iay");
        ra.add("iay");
        ra.add("ikan");
        ra.add("ikan");
        ra.remove(1);
        assertArrayEquals(ra.toArray(), bean.toArray());
    }

}
