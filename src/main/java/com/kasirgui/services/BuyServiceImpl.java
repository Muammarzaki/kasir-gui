package com.kasirgui.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kasirgui.model.BuyFormat;
import com.kasirgui.model.FormatSaver;

public class BuyServiceImpl implements BuyServices {
    public List<FormatSaver> listProduct;

    /**
     * @param listProduct
     */
    public BuyServiceImpl(List<FormatSaver> listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public void countAndCounter(List<BuyFormat> dataProduct, String productName, Integer amount)
            throws Exception {
        Optional<BuyFormat> findFirst = dataProduct.stream().filter(x -> x.getName().equals(productName))
                .findFirst();
        if (findFirst.isPresent()) {
            BuyFormat currentProduct = findFirst.get();
            currentProduct.setJumlah(currentProduct.getJumlah() + amount)
                    .setTotalPrice(currentProduct.getJumlah() * currentProduct.getUnitPrice());
        } else {
            Optional<FormatSaver> productEntity = listProduct.stream()
                    .filter(x -> x.getProductName().equals(productName)).findFirst();
            if (productEntity.isPresent()) {
                Double price = productEntity.get().getPrice();
                dataProduct.add(new BuyFormat().setName(productName).setJumlah(amount).setUnitPrice(price)
                        .setTotalPrice(price * amount));
            }
        }
    }

    @Override
    public Double getTotal(List<BuyFormat> dataProduct) throws Exception {
        Map<String, Double> total = dataProduct.stream()
                .collect(Collectors.groupingBy(BuyFormat::getName, Collectors.summingDouble(BuyFormat::getTotalPrice)));
        Double totalPrice = total.values().stream().reduce(0d, Double::sum);
        System.out.println(totalPrice);
        return totalPrice;
    }

}
