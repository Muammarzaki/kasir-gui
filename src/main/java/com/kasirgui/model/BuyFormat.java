package com.kasirgui.model;

public class BuyFormat {
    private String name;
    private Integer jumlah;
    private Integer unitPrice;
    private Integer totalPrice;

    public BuyFormat() {
    }

    public BuyFormat(String name, Integer jumlah, Integer unitPrice, Integer totalPrice) {
        this.name = name;
        this.jumlah = jumlah;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

}
