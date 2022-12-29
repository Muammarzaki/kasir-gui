package com.kasirgui.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.kasirgui.model.SimpleProductSaverFormat;

public class JsonHandlerImplTest {
    private JsonHandlerImpl json;

    @Order(2)
    @Test
    void testRead() {
        json = new JsonHandlerImpl();
        assertDoesNotThrow(() -> {
            assertNotNull(json.read());

        });
    }

    @Order(1)
    @Test
    void testWrite() {
        List<SimpleProductSaverFormat> data = List.of(new SimpleProductSaverFormat("i", "ikan", 7d, 6d));
        json = new JsonHandlerImpl();
        assertDoesNotThrow(() -> {
            json.write(data);
        });
    }

    @AfterAll
    static void afterClass() {
        JsonHandlerImpl json = new JsonHandlerImpl();
        try {
            Files.delete(json.getFileSave());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
