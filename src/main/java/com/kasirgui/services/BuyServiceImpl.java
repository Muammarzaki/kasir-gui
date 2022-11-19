package com.kasirgui.services;

import java.util.List;

import com.kasirgui.model.BuyFormat;

public class BuyServiceImpl implements BuyServices {
    private List<BuyFormat> barang;

    @Override
    public Double call() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Double count() {
        return null;
    }

    @Override
    public void counter(String nameProduct, Integer jumlah) {
        this.barang.stream().map(x -> {
            if (x.getName().equals(nameProduct)) {
                x.setJumlah(x.getJumlah() + jumlah);
            }
            return x;
        });
    }

    public Boolean isProductCorrect() {
        // check is is product correct
        return false;
    }
}
