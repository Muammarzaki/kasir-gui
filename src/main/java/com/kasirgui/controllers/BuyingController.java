
package com.kasirgui.controllers;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import com.kasirgui.model.ListProduct;
import com.kasirgui.model.TableBuy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class BuyingController implements Initializable {
    @FXML
    private TableView<TableBuy> buyTable;

    @FXML
    private Button cancle;

    @FXML
    private TableColumn<TableBuy, Integer> count;

    @FXML
    private TableColumn<ListProduct, Integer> listName;

    @FXML
    private TableColumn<ListProduct, Integer> listPrice;

    @FXML
    private TableColumn<ListProduct, Integer> listStock;

    @FXML
    private TableView<ListProduct> listTable;

    @FXML
    private TableView<ListProduct> listTableSold;

    @FXML
    private TableColumn<TableBuy, Integer> priceOfOne;

    @FXML
    private TextField countField;

    @FXML
    private TableColumn<TableBuy, String> product;

    @FXML
    private TableColumn<?, ?> soldProduct;

    @FXML
    private TableColumn<?, ?> soldstock;

    @FXML
    private Button submit;

    @FXML
    private TextField totalBuy;

    @FXML
    private TableColumn<TableBuy, Integer> totalPrice;

    private ObservableList<TableBuy> buyList = FXCollections.observableArrayList(
            new TableBuy("ayam", 10, 40000, 20000),
            new TableBuy("ayam", 10, 40000, 20000),
            new TableBuy("ayam", 10, 40000, 20000),
            new TableBuy("ayam", 10, 40000, 20000));

    private ObservableList<ListProduct> list = FXCollections.observableArrayList(
            new ListProduct("ikan", 2000, 4), new ListProduct("ikan", 2000, 0), new ListProduct("ikan", 2000, 4));

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        initBuyTable();
        initListTable();
    }

    // start event
    @FXML
    void cancleClick(MouseEvent event) {
        System.out.println("cancle");
    }

    @FXML
    void hitungClick(MouseEvent event) {
        System.out.println("hitung click");
    }

    @FXML
    void hitungEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            System.out.println("hitung enter");
            countField.clear();
        }

    }

    public Boolean issame(Map<String, Double> map, String key) {
        if (map.containsKey(key)) {
            // TODO must fixing when key is data form file
            map.put(key, map.get(key));
            return true;
        } else {
            map.put(key, null);
            return false;
        }
    }

    @FXML
    void submitClick(MouseEvent event) {
        System.out.println("submit");

    }

    // end event
    // initial of view
    private void initListTable() {
        listName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        listStock.setCellValueFactory(new PropertyValueFactory<>("Price"));
        listPrice.setCellValueFactory(new PropertyValueFactory<>("Stock"));

        soldProduct.setCellValueFactory(new PropertyValueFactory<>("Name"));
        soldstock.setCellValueFactory(new PropertyValueFactory<>("Stock"));

        listTable.setItems(list);
    }

    private void initBuyTable() {
        product.setCellValueFactory(new PropertyValueFactory<>("Name"));
        count.setCellValueFactory(new PropertyValueFactory<>("Jumlah"));
        priceOfOne.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));
        totalPrice.setCellValueFactory(new PropertyValueFactory<>("TotalPrice"));

        buyTable.setItems(buyList);
    }
    // end of initial view
}
