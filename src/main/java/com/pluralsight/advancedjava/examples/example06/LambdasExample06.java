package main.java.com.pluralsight.advancedjava.examples.example06;

import java.math.BigDecimal;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LambdasExample06 {

    public static void main(String[] args) {
        var products = List.of(
                new Product(100100L, "apple", new BigDecimal("1.10")),
                new Product(200200L, "chip", new BigDecimal("0.00")),
                new Product(300301L, "park", new BigDecimal("1.91")),
                new Product(400401L, "friend", new BigDecimal("0.01")));

        var expensiveProducts = products.stream().filter(LambdasExample06::isExpensive).toList();

        expensiveProducts.forEach(System.out::println);

        var totalPrice = products.stream().map(Product::price).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total price: " + totalPrice);

        var productNames = products.stream().map(Product::name).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(productNames);
    }

    static boolean isExpensive(Product product) {
        return product.price().compareTo(new BigDecimal("4.00")) >= 0;
    }
}

record Product(long id, String name, BigDecimal price) {}
