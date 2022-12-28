package com.kasirgui.model;

public class SimpleProductSaverFormat {

    private String id;

    private String name;

    private Double price;

    private Double stock;

    /**
     * 
     */
    public SimpleProductSaverFormat() {
    }

    /**
     * @param id
     * @param name
     * @param price
     * @param stock
     */
    public SimpleProductSaverFormat(String id, String name, Double price, Double stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the stock
     */
    public Double getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(Double stock) {
        this.stock = stock;
    }

}