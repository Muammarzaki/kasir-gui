package com.kasirgui.services;

import java.util.List;

import com.kasirgui.helpers.JsonHandlerSingelton;
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
    void count(String name, Integer count) throws Exception;

    /**
     * melakukan counter harga dan jumlah barang serta mengurangi jumlah barang di
     * dalam data
     */
    void counter(String name, Integer count);

    /**
     * get data dari table / json file dgn mengakses json data handler
     * 
     * @return JsonHandler<formatSaver>
     */
    default JsonHandler<FormatSaver> getData() {
        return JsonHandlerSingelton.getInstance();
    }

    List<BuyFormat> getBarang();
}
