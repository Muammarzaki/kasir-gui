package com.kasirgui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.kasirgui.helpers.DataProductList;
import com.kasirgui.model.SimpleProductSaverFormat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DataInsertDialogController implements Initializable {

    @FXML
    private Button cancelButton;

    @FXML
    private Button finishButton;

    @FXML
    public TextField idField;

    @FXML
    public TextField nameField;

    @FXML
    public TextField priceField;

    @FXML
    public TextField stockField;

    private SimpleProductSaverFormat product;

    private Integer index;

    /**
     * 
     */
    public DataInsertDialogController() {
    }

    /**
     * @param product
     * @param index
     */
    public DataInsertDialogController(SimpleProductSaverFormat product, Integer index) {
        this.product = product;
        this.index = index;
    }

    /**
     * @return the index
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * @return the product
     */
    public SimpleProductSaverFormat getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(SimpleProductSaverFormat product) {
        this.product = product;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        finishButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                CreateProduct();
                close();
            }

        });

        cancelButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // ! di isi atuh
                close();
            }

        });
    }

    public void CreateProduct() {
        if (idField != null && nameField != null && priceField != null && stockField != null) {
            this.product = new SimpleProductSaverFormat(idField.getText(),
                    nameField.getText(), Double.parseDouble(priceField.getText()),
                    Double.parseDouble(stockField.getText()));
            if (index != null) {
                DataProductList.getData().set(index, product);
            } else {
                DataProductList.getData().add(product);
            }

        }

    }
    void close() {
        Stage window = (Stage) idField.getScene().getWindow();
        window.close();

    }
}
