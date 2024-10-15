package main.java.com.pluralsight.advancedjava.examples.example05;

import java.math.BigDecimal;

public record OrderLine(Product product, int quantity, BigDecimal price) {
}
