package com.kasirgui.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kasirgui.model.BuyFormat;
import com.kasirgui.model.FormatSaver;

public class BuyServiceImplTest {
    BuyServiceImpl buy;
    List<BuyFormat> selectedProduct;

    @BeforeEach
    void setUp() {
        List<FormatSaver> data = List.of(new FormatSaver("ikan", 3000d, 3d),
                new FormatSaver("ayam", 3200d, 3d), new FormatSaver("babi", 2000d, 3d));
        buy = new BuyServiceImpl(data);
        selectedProduct = List.of(new BuyFormat("ikan", 2, 3000d, 6000d), new BuyFormat("ayam", 2, 3200d, 6400d));
    }

    @Test
    void testCountAndCounter() {
        try {
            buy.countAndCounter(selectedProduct, "babi", 3);
            buy.countAndCounter(selectedProduct, "babi", 3);
            assertEquals(3, selectedProduct.size());
            assertEquals(6,
                    selectedProduct.stream().filter(x -> x.getName().equals("babi")).findFirst().get().getJumlah());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetTotal() {

        try {
            Double total = buy.getTotal(selectedProduct);
            assertNotNull(total);
        } catch (Exception e) {
            System.err.println(e.getCause() + " " + e.getMessage());
        }
    }

}