package com.kasirgui.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.kasirgui.model.BuyFormat;
import com.kasirgui.model.SimpleProductSaverFormat;

public class BuyServiceImplTest {

    @Test
    public void testCountAndCounter() throws Exception {
        List<SimpleProductSaverFormat> data = List.of(new SimpleProductSaverFormat("i", "ikan", 3000d, 3d),
                new SimpleProductSaverFormat("a", "ayam", 3200d, 10d),
                new SimpleProductSaverFormat("b", "babi", 2000d, 10d));
        BuyServiceImpl buy = new BuyServiceImpl(data);
        List<BuyFormat> selectedProduct = new ArrayList<>();
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
        List<SimpleProductSaverFormat> data = List.of(new SimpleProductSaverFormat("i", "ikan", 3000d, 3d),
                new SimpleProductSaverFormat("a", "ayam", 3200d, 3d),
                new SimpleProductSaverFormat("b", "babi", 2000d, 3d));
        BuyServiceImpl buy = new BuyServiceImpl(data);
        List<BuyFormat> selectedProduct = new ArrayList<>();
        ;
        assertDoesNotThrow(() -> {
            Double total = buy.getTotal(selectedProduct);
            assertNotNull(total);

        });
    }

}
