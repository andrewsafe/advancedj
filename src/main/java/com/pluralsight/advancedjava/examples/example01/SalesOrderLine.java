package main.java.com.pluralsight.advancedjava.examples.example01;

import main.java.com.pluralsight.advancedjava.examples.example05.Product;

import java.math.BigDecimal;

public record SalesOrderLine(Product product, int quality, BigDecimal amount) implements OrderLine {
    public int quantity() {
        return 0;
    }
}
