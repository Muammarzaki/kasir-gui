package com.kasirgui.helpers;

import java.io.IOException;
import java.util.List;

import com.kasirgui.model.SimpleProductSaverFormat;
import com.kasirgui.services.JsonHandlerImpl;

public class DataSaveTriger {
    private static JsonHandlerImpl json = new JsonHandlerImpl();

    /**
     * 
     */
    private DataSaveTriger() {
    }

    public static void save() {
        try {
            List<SimpleProductSaverFormat> data = DataProductList.getData();
            if (!data.isEmpty()) {
                json.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getData() {
        try {
            List<SimpleProductSaverFormat> read = json.read();
            DataProductList.setData(read);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
