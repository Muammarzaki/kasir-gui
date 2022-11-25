package com.kasirgui.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.kasirgui.helpers.JsonHandlerSingelton;
import com.kasirgui.model.BuyFormat;
import com.kasirgui.model.FormatSaver;

public class BuyServiceImpl implements BuyServices {
    private List<BuyFormat> barang;
    private final JsonHandler<FormatSaver> JSON = JsonHandlerSingelton.getInstance();

    @Override
    public void count(String nameProduct, Integer jumlahProduct) {
        try {
            if (!this.barang.stream().anyMatch(x -> x.getName().equals(nameProduct))) {
                Integer price;
                price = getPrice(nameProduct);
                this.barang.add(new BuyFormat(nameProduct, jumlahProduct, price, jumlahProduct * price));
            } else {
                this.count(nameProduct, jumlahProduct);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void counter(String nameProduct, Integer jumlah) {
        Stream<BuyFormat> counter = this.barang.stream().map(x -> {
            if (x.getName().equals(nameProduct)) {
                x.setJumlah(x.getJumlah() + jumlah);
            }
            return x;
        }).map(x -> {
            x.setTotalPrice(x.getJumlah() * x.getUnitPrice());
            return x;
        });
        this.barang = counter.collect(Collectors.toList());
    }

    private Integer getPrice(String productName) throws Exception {
        return Arrays.asList(JSON.read()).stream().filter(x -> x.getProductName().equals(productName))
                .collect(Collectors.toList()).get(0)
                .getPrice().intValue();
    }

    public Boolean isProductCorrect() {
        // check is is product correct
        return false;
    }
}
