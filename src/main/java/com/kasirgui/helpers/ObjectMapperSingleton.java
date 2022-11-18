package com.kasirgui.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperSingleton {
    private static ObjectMapper mapper;

    /**
     * 
     */
    private ObjectMapperSingleton() {
    }

    public static ObjectMapper getInstace() {
        if (mapper == null) {
            mapper = new ObjectMapper();
        }
        return mapper;
    }

}
