package com.kasirgui.helpers;

import com.kasirgui.model.FormatSaver;
import com.kasirgui.services.JsonHandler;
import com.kasirgui.services.JsonHandlerImpl;

public class ProductSaver {
    private static JsonHandler<FormatSaver> jsonHandler;

    /**
     * 
     */
    private ProductSaver() {
        // just implements singleton
    }

    public static JsonHandler<FormatSaver> getInstance() {
        jsonHandler = jsonHandler == null ? new JsonHandlerImpl<>() : jsonHandler;
        return jsonHandler;
    }
}