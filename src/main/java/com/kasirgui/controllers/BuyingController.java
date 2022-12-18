
package com.kasirgui.controllers;

import java.net.URL;
// import java.util.Map;
import java.util.ResourceBundle;

import com.kasirgui.model.ListProduct;
import com.kasirgui.services.BuyServiceImpl;
import com.kasirgui.services.BuyServices;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.kasirgui.model.BuyFormat;

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
    private BuyServices service = new BuyServiceImpl();

    @FXML
    private TableView<BuyFormat> buyTable;

    @FXML
    private Button cancle;

    @FXML
    private TableColumn<BuyFormat, Integer> count;

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
    private TableColumn<BuyFormat, Integer> priceOfOne;

    @FXML
    private TextField countField;

    @FXML
    private TableColumn<BuyFormat, String> product;

    @FXML
    private TableColumn<?, ?> soldProduct;

    @FXML
    private TableColumn<?, ?> soldstock;

    @FXML
    private Button submit;

    @FXML
    private TextField totalBuy;

    @FXML
    private TableColumn<BuyFormat, Integer> totalPrice;

    private ObservableList<BuyFormat> buyList = FXCollections.observableArrayList(
            new BuyFormat("ayam", 10, 40000, 20000),
            new BuyFormat("ayam", 10, 40000, 20000),
            new BuyFormat("ayam", 10, 40000, 20000),
            new BuyFormat("ayam", 10, 40000, 20000));

    private ObservableList<ListProduct> list = FXCollections.observableArrayList(
            new ListProduct("ikan", 2000, 4), new ListProduct("ikan", 2000, 0), new ListProduct("ikan", 2000, 4));

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        initBuyTable();
        initListTable();
    }

    @FXML
    void cancleClick(MouseEvent event) {
        System.out.println("cancle");
    }

    @FXML
    void hitungClick(MouseEvent event) {
        try {
            System.out.println("hitung click");
            String[] text = countField.getText().split(" ");
            if (text.length == 2) {
                service.count(text[0], Integer.parseInt(text[1]));
            } else {
                service.count(text[0], 1);
            }
        } catch (InvalidDefinitionException e) {
            System.err.println("product no found");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /*
     * hitung dengan enter
     */
    @FXML
    void hitungEnter(KeyEvent event) {
        try {
            if (event.getCode() == KeyCode.ENTER) {
                System.out.println("hitung enter");
                String[] text = countField.getText().split(" ");
                if (text.length == 2) {
                    service.count(text[0], Integer.parseInt(text[1]));
                } else {
                    service.count(text[0], 1);
                }
                countField.clear();
            }
        } catch (InvalidDefinitionException e) {
            System.err.println("product no found");
        } catch (Exception e) {
            countField.clear();
            System.err.println(e);
        }
    }

    // public Boolean issame(Map<String, Double> map, String key) {
    // if (map.containsKey(key)) {
    // // must fixing when key is data form file
    // map.put(key, map.get(key));
    // return true;
    // } else {
    // map.put(key, null);
    // return false;
    // }
    // }

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
