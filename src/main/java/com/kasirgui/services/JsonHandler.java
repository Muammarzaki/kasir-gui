package com.kasirgui.services;

import java.util.List;

/**
 * JsonHandler
 */
public interface JsonHandler<T> {

    /**
     * write data to json file
     * 
     * @param data
     */
    void write(List<T> data) throws Exception;

    /**
     * read json file to pojo
     * 
     * @return
     */
    List<T> read() throws Exception;
}