package com.kasirgui.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.kasirgui.helpers.JsonHandlerSingelton;
import com.kasirgui.model.BuyFormat;
import com.kasirgui.model.FormatSaver;

public class BuyServiceImpl implements BuyServices {
    public List<BuyFormat> barang = new ArrayList<>();
    private final JsonHandler<FormatSaver> json = JsonHandlerSingelton.getInstance();

    /*
     * untuk menghitung harga barang
     */
    @Override
    public void count(String nameProduct, Integer jumlahProduct) throws Exception {
        if (!this.barang.stream().anyMatch(x -> x.getName().equals(nameProduct))) {
            Integer price;
            price = getPrice(nameProduct);
            if (price == null) {
                throw new NullPointerException("barang tidak ada");
            }
            this.barang.add(new BuyFormat(nameProduct, jumlahProduct, price, jumlahProduct * price));
        } else {
            this.counter(nameProduct, jumlahProduct);
        }
    }

    @Override
    public void counter(String nameProduct, Integer jumlah) {
        Stream<BuyFormat> counter = this.barang.stream().map(x -> {
            // set jumlah barang baru
            if (x.getName().equals(nameProduct)) {
                x.setJumlah(x.getJumlah() + jumlah);
            }
            return x;
        }).map(x -> {
            // set harga total dari barang tsb
            x.setTotalPrice(x.getJumlah() * x.getUnitPrice());
            return x;
        });
        this.barang = counter.collect(Collectors.toList());
    }

    private Integer getPrice(String productName) throws Exception {
        return Arrays.asList(json.read()).stream().filter(x -> x.getProductName().equals(productName))
                .collect(Collectors.toList()).get(0)
                .getPrice().intValue();
    }

    public Boolean isProductCorrect() {
        // check is is product correct
        return false;
    }

    @Override
    public List<BuyFormat> getBarang() {
        return this.barang;
    }
}
