package com.kasirgui.helpers;

import java.util.ArrayList;
import java.util.List;

import com.kasirgui.model.SimpleProductSaverFormat;

public class DataProductList {
    private static List<SimpleProductSaverFormat> data;

    /**
     * 
     */
    private DataProductList() {
        // nothing to do
    }

    /**
     * @param data the data to set
     * @return
     */
    public static List<SimpleProductSaverFormat> getData() {
        if (data == null) {
            data = new ArrayList<>();
        }
        return data;
    }

}
