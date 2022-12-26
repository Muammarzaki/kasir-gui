
package com.kasirgui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.kasirgui.App;
import com.kasirgui.model.BuyFormat;
import com.kasirgui.model.FormatSaver;
import com.kasirgui.model.SimpleProductFormat;
import com.kasirgui.services.BuyServiceImpl;
import com.kasirgui.services.BuyServices;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class BuyingController implements Initializable {
    private BuyServices buyService;

    private List<BuyFormat> productBuying = new ArrayList<>();

    private List<SimpleProductFormat> listSimpleProduct = new ArrayList<>();

    @FXML
    private TableView<BuyFormat> buyTable;

    @FXML
    private Button cancle;

    @FXML
    private TableColumn<BuyFormat, Integer> count;

    @FXML
    private TableColumn<SimpleProductFormat, Integer> listName;

    @FXML
    private TableColumn<SimpleProductFormat, Integer> listPrice;

    @FXML
    private TableColumn<SimpleProductFormat, Integer> listStock;

    @FXML
    private TableView<SimpleProductFormat> listTable;

    @FXML
    private TableView<SimpleProductFormat> listTableSold;

    @FXML
    private TableColumn<BuyFormat, Integer> priceOfOne;

    @FXML
    private TextField countField;

    @FXML
    private TableColumn<BuyFormat, String> product;

    @FXML
    private TableColumn<?, ?> soldProduct;

    @FXML
    private Button totalButton;

    @FXML
    private TableColumn<?, ?> soldstock;

    @FXML
    private Button submit;

    @FXML
    private TextField totalBuy;

    @FXML
    private TableColumn<BuyFormat, Integer> totalPrice;
    @FXML
    private Pane dataProductPane;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        List<FormatSaver> data = List.of(new FormatSaver("ikan", 3000d, 3d),
                new FormatSaver("ayam", 3200d, 3d), new FormatSaver("babi", 2000d, 3d),
                new FormatSaver("buaya", 7000d, 0d));
        try {
            buyService = new BuyServiceImpl(data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        data.forEach(
                x -> listSimpleProduct
                        .add(new SimpleProductFormat(x.getProductName(), x.getPrice().intValue(),
                                x.getStock().intValue())));
        dataProductPane.setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event arg0) {
                try {
                    App.setRoot("data-product");
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }

        });
        product.setCellValueFactory(new PropertyValueFactory<>("Name"));
        count.setCellValueFactory(new PropertyValueFactory<>("Jumlah"));
        priceOfOne.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));
        totalPrice.setCellValueFactory(new PropertyValueFactory<>("TotalPrice"));
        buyTable.setItems(FXCollections.observableList(productBuying));

        listName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        listStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        listPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        soldProduct.setCellValueFactory(new PropertyValueFactory<>("Name"));
        soldstock.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        listTableSold.setItems(
                FXCollections.observableList(
                        listSimpleProduct.stream().filter(x -> x.getStock() == 0).collect(Collectors.toList())));
        listTable.setItems(FXCollections.observableList(listSimpleProduct));

    }

    @FXML
    void cancleClick(MouseEvent event) {
        productBuying.clear();
        buyTable.refresh();
        totalBuy.clear();
        System.out.println("cancle");
    }

    @FXML
    void hitungClick(MouseEvent event) {
        try {
            System.out.println("hitung click");
            String[] text = countField.getText().trim().split(" ");
            if (text.length == 2) {
                buyService.countAndCounter(productBuying, text[0], Integer.parseInt(text[1]));
            } else {
                buyService.countAndCounter(productBuying, text[0], 1);
            }
            countField.clear();
            buyTable.refresh();
            totalSchedule();
        } catch (

        InvalidDefinitionException e) {
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
                String[] text = countField.getText().trim().split(" ");
                if (text.length == 2) {
                    buyService.countAndCounter(productBuying, text[0], Integer.parseInt(text[1]));
                } else {
                    buyService.countAndCounter(productBuying, text[0], 1);
                }
                countField.clear();
                buyTable.refresh();
                totalSchedule();
            }

        } catch (InvalidDefinitionException e) {
            System.err.println("product no found");
            countField.clear();
        } catch (Exception e) {
            countField.clear();
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void totalClickForpay(MouseEvent event) {
        try {
            totalSchedule();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void totalSchedule() throws Exception {
        Double total = buyService.getTotal(productBuying);
        totalBuy.setText(String.format("Rp. %,d", Math.round(total)));

    }

    @FXML
    void submitClick(MouseEvent event) {
        try {
            popup();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("submit");
    }

    public void popup() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("pay-dialog.fxml"));
        DialogPane popupPane = fxmlLoader.load();
        PayDialogController buycontrol = fxmlLoader.getController();

        try {
            buycontrol.total.setText(String.format("Rp. %,d", Math.round(buyService.getTotal(productBuying))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Dialog<ButtonType> dialog = new Dialog<>();

        dialog.setDialogPane(popupPane);

        Optional<ButtonType> selected = dialog.showAndWait();

        // ! fucking dev fixing this motherfucker make a aundit
        if (selected.get() == ButtonType.FINISH) {
            App.setRoot("buy");
            System.out.println("oke");
        } else if (selected.get() == ButtonType.CANCEL) {
            System.out.println("oke di cancle");
        } else {
            // nothing to do
        }

    }

}
