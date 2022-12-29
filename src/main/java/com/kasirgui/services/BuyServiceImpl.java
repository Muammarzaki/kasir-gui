package com.kasirgui.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kasirgui.model.BuyFormat;
import com.kasirgui.model.SimpleProductSaverFormat;

public class BuyServiceImpl implements BuyServices {
    private List<SimpleProductSaverFormat> listProduct;

    /**
     * @param list
     */
    public BuyServiceImpl(List<SimpleProductSaverFormat> list) {
        this.listProduct = list;
    }

    @Override
    public void countAndCounter(List<BuyFormat> dataProduct, String productName, Integer amount) throws Exception {

        Optional<BuyFormat> findFirst = dataProduct.stream().filter(x -> x.getName().equals(productName))
                .findFirst();
        Optional<SimpleProductSaverFormat> productEntity = listProduct.stream()
                .filter(x -> x.getName().equals(productName)).findFirst();

        SimpleProductSaverFormat product = productEntity.get();
        if (product.getStock() > 0) {
            if (findFirst.isPresent()) {
                BuyFormat currentProduct = findFirst.get();
                currentProduct.setJumlah(currentProduct.getJumlah() + amount)
                        .setTotalPrice(currentProduct.getJumlah() * currentProduct.getUnitPrice());
            } else {
                if (productEntity.isPresent()) {
                    Double price = product.getPrice();
                    dataProduct.add(new BuyFormat().setName(productName).setJumlah(amount).setUnitPrice(price)
                            .setTotalPrice(price * amount));
                }
            }

            product.setStock(product.getStock() - amount);
        } else {
            throw new Exception("Product sold need Restock");
        }
    }

    @Override
    public Double getTotal(List<BuyFormat> dataProduct) throws Exception {
        Map<String, Double> total = dataProduct.stream()
                .collect(Collectors.groupingBy(BuyFormat::getName, Collectors.summingDouble(BuyFormat::getTotalPrice)));
        return total.values().stream().reduce(0d, Double::sum);
    }

}
