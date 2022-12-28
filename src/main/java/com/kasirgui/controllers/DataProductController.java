/**
 * Sample Skeleton for 'data-product.fxml' Controller Class
 */

package com.kasirgui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.kasirgui.App;
import com.kasirgui.helpers.DataProductList;
import com.kasirgui.model.SimpleProductSaverFormat;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DataProductController {
    /**
     *
     */
    private static final String MESSAGE = "Message";

    private List<SimpleProductSaverFormat> productSavers = DataProductList.getData();

    @FXML
    private AnchorPane buydiarect;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="col1"
    private TableColumn<?, ?> col1; // Value injected by FXMLLoader

    @FXML // fx:id="col2"
    private TableColumn<?, ?> col2; // Value injected by FXMLLoader

    @FXML // fx:id="col3"
    private TableColumn<?, ?> col3; // Value injected by FXMLLoader

    @FXML // fx:id="col4"
    private TableColumn<?, ?> col4; // Value injected by FXMLLoader

    @FXML // fx:id="col5"
    private TableColumn<?, ?> col5; // Value injected by FXMLLoader

    @FXML // fx:id="col6"
    private TableColumn<?, ?> col6; // Value injected by FXMLLoader

    @FXML // fx:id="deleteButton"
    private Button deleteButton; // Value injected by FXMLLoader

    @FXML // fx:id="insertButton"
    private Button insertButton; // Value injected by FXMLLoader

    @FXML // fx:id="tableDataProduct"
    private TableView<SimpleProductSaverFormat> tableDataProduct; // Value injected by FXMLLoader

    @FXML // fx:id="updateButton"
    private Button updateButton; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        // ! tunggu asu
        col1.setCellValueFactory(new PropertyValueFactory<>("name"));
        col1.setText("Nama Product");
        col2.setCellValueFactory(new PropertyValueFactory<>("price"));
        col2.setText("Price Product");
        col3.setCellValueFactory(new PropertyValueFactory<>("stock"));
        col3.setText("Stock Product");
        tableDataProduct.setItems(FXCollections.observableList(productSavers));

        buydiarect.setOnMouseReleased(new EventHandler<Event>() {
            @Override
            public void handle(Event arg0) {
                try {
                    App.setRoot("buy");
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                }
            }

        });

        updateButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                try {
                    FXMLLoader fxml = new FXMLLoader(App.class.getResource("data-insert.fxml"));

                    Stage modal = new Stage();
                    Parent load = fxml.load();
                    modal.setScene(new Scene(load));
                    modal.setTitle("Insert Data");
                    DataInsertDialogController dataInsertControl = fxml.getController();
                    int index = tableDataProduct.getSelectionModel().getSelectedIndex();
                    if (index > -1) {
                        SimpleProductSaverFormat product = productSavers.get(index);
                        if (product != null) {
                            dataInsertControl.idField.setText(product.getId());
                            dataInsertControl.idField.setEditable(false);
                            dataInsertControl.idField.setMouseTransparent(true);
                            dataInsertControl.idField.setFocusTraversable(false);
                            dataInsertControl.nameField.setText(product.getName());
                            dataInsertControl.priceField.setText(product.getPrice().toString());
                            dataInsertControl.stockField.setText(product.getStock().toString());
                            dataInsertControl.setIndex(index);
                            dataInsertControl.setProduct(product);
                        }
                        // fxml.setController(dataInsertControl);
                        modal.initModality(Modality.APPLICATION_MODAL);
                        modal.setResizable(true);
                        modal.showAndWait();
                        tableDataProduct.refresh();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle(MESSAGE);
                        alert.setHeaderText("must selection a row in table");
                    }

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

        });
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                Integer index = tableDataProduct.getSelectionModel().getSelectedIndex();
                if (index > -1) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle(MESSAGE);
                    alert.setHeaderText("Are you sure you want to delete this row?");
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get().equals(ButtonType.OK)) {
                        productSavers.remove((int) index);
                    }
                } else {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle(MESSAGE);
                    alert.setHeaderText("must selection a row at table");
                    alert.show();
                }
                tableDataProduct.refresh();
            }

        });

        insertButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                try {
                    FXMLLoader fxml = new FXMLLoader(App.class.getResource("data-insert.fxml"));

                    Stage modal = new Stage();
                    Parent load = fxml.load();
                    modal.setScene(new Scene(load));
                    modal.setTitle("Insert Data");
                    // DataInsertDialogController dataInsertControl = fxml.getController();
                    modal.initModality(Modality.APPLICATION_MODAL);
                    modal.showAndWait();

                    tableDataProduct.refresh();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                tableDataProduct.refresh();
            }
        });
    }

    int getTableIndexSelected() {
        return tableDataProduct.getSelectionModel().getSelectedIndex();
    }

}
