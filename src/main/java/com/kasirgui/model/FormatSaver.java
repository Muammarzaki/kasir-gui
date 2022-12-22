package com.kasirgui.model;

import java.io.Serializable;
import java.util.Set;

/**
 * FormatSaver
 */
public class FormatSaver implements Serializable {
    private Long id;
    private String productName;
    private Double price;
    private Double stock;
    private Boolean delete;
    private Set<String> category;

    /**
     * 
     */
    public FormatSaver() {
    }

    /**
     * @param productName
     * @param price
     * @param stock
     */
    public FormatSaver(String productName, Double price, Double stock) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

    /**
     * @param id
     * @param productName
     * @param price
     * @param stock
     * @param delete
     * @param category
     */
    public FormatSaver(Long id, String productName, Double price, Double stock, Boolean delete, Set<String> category) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.delete = delete;
        this.category = category;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
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

    /**
     * @return the delete
     */
    public Boolean getDelete() {
        return delete;
    }

    /**
     * @param delete the delete to set
     */
    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    /**
     * @return the category
     */
    public Set<String> getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Set<String> category) {
        this.category = category;
    }
}
