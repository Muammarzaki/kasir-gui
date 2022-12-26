package com.kasirgui.services;

import java.util.List;

import com.kasirgui.model.SimpleProductFormat;
import com.kasirgui.model.SimpleProductSaverFormat;

/**
 * JsonHandler
 */
public interface JsonHandler<T> {

    /**
     * write data to json file
     * 
     * @param data
     */
    void write(List<SimpleProductSaverFormat> data) throws Exception;

    /**
     * read json file to pojo
     * 
     * @return
     */
    List<SimpleProductSaverFormat> read() throws Exception;
}