package com.kasirgui.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.kasirgui.model.BuyFormat;
import com.kasirgui.model.FormatSaver;

public class BuyServiceImplTest {

    List<FormatSaver> data = List.of(new FormatSaver("ikan", 3000d, 3d),
            new FormatSaver("ayam", 3200d, 3d), new FormatSaver("babi", 2000d, 3d));
    public BuyServiceImpl buy = new BuyServiceImpl(data);
    public List<BuyFormat> selectedProduct = new ArrayList<>();;

    @Test
    public void testCountAndCounter() throws Exception {
        selectedProduct
                .addAll(Arrays.asList(new BuyFormat("ikan", 2, 3000d, 6000d), new BuyFormat("ayam", 2, 3200d, 6400d)));
        buy.countAndCounter(selectedProduct, "babi", 3);
        buy.countAndCounter(selectedProduct, "babi", 3);
        assertEquals(3, selectedProduct.size());
        assertEquals(6,
                selectedProduct.stream().filter(x -> x.getName().equals("babi")).findFirst().get().getJumlah());

    }

    @Test
    void testGetTotal() {
        assertDoesNotThrow(() -> {
            Double total = buy.getTotal(selectedProduct);
            assertNotNull(total);

        });
    }

}
