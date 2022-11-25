package com.kasirgui.services;

import com.kasirgui.model.FormatSaver;

/**
 * JsonHandler
 */
public interface JsonHandler<T> {

    /**
     * write data to json file
     * 
     * @param data
     */
    void write(T[] data) throws Exception;

    /**
     * read json file to pojo
     * 
     * @return
     */
    FormatSaver[] read() throws Exception;
}