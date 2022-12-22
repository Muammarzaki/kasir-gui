package com.kasirgui.model;

public class BuyFormat {
    private String name;
    private Integer jumlah;
    private Double unitPrice;
    private Double totalPrice;

    public BuyFormat() {
    }

    public BuyFormat(String name, Integer jumlah, Double unitPrice, Double totalPrice) {
        this.name = name;
        this.jumlah = jumlah;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public BuyFormat setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public BuyFormat setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
        return this;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public BuyFormat setUnitPrice(Double double1) {
        this.unitPrice = double1;
        return this;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public BuyFormat setTotalPrice(double d) {
        this.totalPrice = d;
        return this;
    }

}
