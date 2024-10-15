package main.java.com.pluralsight.advancedjava.examples.example10;

import main.java.com.pluralsight.advancedjava.examples.example05.Product;

import java.math.BigDecimal;

public class RecordsExample10 {

    public static void main(String[] args) {
        var product = new Product(100123L, "Yousef", "lil guy");

        var line = new OrderLine(product, 6, new BigDecimal("6.02"));

        var newLine1 = new OrderLine(line.product(), line.quantity(), new BigDecimal("5.44"));

        var newLine2 = line.withQuantity(8).withPrice(new BigDecimal("8.64"));
    }
}
