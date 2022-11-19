package com.kasirgui.services;

import java.util.concurrent.Callable;

import com.kasirgui.helpers.JsonHandlerSingelton;
import com.kasirgui.model.FormatSaver;

/**
 * BuyServices
 */
public interface BuyServices extends Callable<Double> {

    /**
     * hitung total harga perbarang
     */
    Double count();

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
}
