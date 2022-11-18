package com.kasirgui.model;

import java.util.Set;

/**
 * FormatSaver
 */
public class FormatSaver {
    private Long id;
    private String productName;
    private Double price;
    private Double stock;
    private Boolean delete;
    private Set<String> category;

    public FormatSaver(String productName, Double price, Double stock, Boolean delete, Set<String> category) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.delete = delete;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public Set<String> getCategory() {
        return category;
    }

    public void setCategory(Set<String> category) {
        this.category = category;
    }

}
