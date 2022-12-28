package com.kasirgui.services;

import java.util.List;

import com.kasirgui.model.BuyFormat;

/**
 * BuyServices
 */
public interface BuyServices {

    /**
     * hitung total harga perbarang
     * 
     * @throws Exception
     */
    void countAndCounter(List<BuyFormat> dataProduct, String productName, Integer amount) throws Exception;

    /**
     * mendapatkan total dari seluruh harga
     * 
     * @param dataProduct
     * @throws Exception
     */
    Double getTotal(List<BuyFormat> dataProduct) throws Exception;
}
