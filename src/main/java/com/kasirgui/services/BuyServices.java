package com.kasirgui.services;

import java.util.List;

import com.kasirgui.helpers.ProductSaver;
import com.kasirgui.model.BuyFormat;
import com.kasirgui.model.FormatSaver;

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

    /**
     * get data dari table / json file dgn mengakses json data handler
     * 
     * @return JsonHandler<formatSaver>
     * @throws Exception
     */
    static List<FormatSaver> getData() throws Exception {
        return ProductSaver.getInstance().read();
    }
}
