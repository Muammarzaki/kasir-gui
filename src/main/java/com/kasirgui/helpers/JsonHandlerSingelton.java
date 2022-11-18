package com.kasirgui.helpers;

import com.kasirgui.model.FormatSaver;
import com.kasirgui.services.JsonHandler;
import com.kasirgui.services.JsonHandlerImpl;

public class JsonHandlerSingelton {
    private static JsonHandler<FormatSaver> jsonHandler;

    /**
     * 
     */
    private JsonHandlerSingelton() {
        // just implements singleton
    }

    public static JsonHandler<FormatSaver> getInstance() {
        jsonHandler = jsonHandler == null ? new JsonHandlerImpl() : jsonHandler;
        return jsonHandler;
    }
}