package com.kasirgui.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.kasirgui.model.SimpleProductSaverFormat;

public class JsonHandlerImplTest {
    JsonHandler<SimpleProductSaverFormat> json;

    @BeforeEach
    void before() {
        json = new JsonHandlerImpl<>();
    }

    @Disabled
    @Test
    public void testRead() {
        List<SimpleProductSaverFormat> data;
        assertDoesNotThrow(() -> {
            json.read();
        });

        try {
            data = json.read();
            assertNotNull(data);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Disabled
    @Test
    public void testWrite() {

        List<SimpleProductSaverFormat> data = new ArrayList<>();
        data.add(
                new SimpleProductSaverFormat("ikan", 2000d, 3d));
        try {
            json.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void write() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());

        writer.writeValue(new File("kasir-config\\logistic.json"), new SimpleProductSaverFormat("ikan", 400d, 4d));
        // objectMapper.readValue(new File("kasir-config\\logistic.json"),
        // new TypeReference<SimpleProductSaverFormat>() {
        // });
    }
}