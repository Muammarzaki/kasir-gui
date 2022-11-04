package com.kasirgui.services;

/**
 * JsonHandler
 */
public interface JsonHandler<T> {
    /**
     * write data to json file
     * 
     * @param data
     */
    void write(T[] data);

    /**
     * read json file to pojo
     * 
     * @return
     */
    T read();
}