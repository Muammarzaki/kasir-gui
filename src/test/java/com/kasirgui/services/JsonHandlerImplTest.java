package com.kasirgui.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kasirgui.helpers.ProductSaver;
import com.kasirgui.model.FormatSaver;

public class JsonHandlerImplTest {
    JsonHandler<FormatSaver> json;

    @BeforeEach
    void before() {
        json = ProductSaver.getInstance();
    }

    @Test
    public void testRead() {
        List<FormatSaver> data;
        assertDoesNotThrow(() -> {
            json.read();
        });

        try {
            data = json.read();
            assertNotNull(data);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Test
    public void testWrite() {

        assertDoesNotThrow(() -> {
            json.write(List.of(new FormatSaver("ikan", 2000d, 3d)));
        });
    }
}