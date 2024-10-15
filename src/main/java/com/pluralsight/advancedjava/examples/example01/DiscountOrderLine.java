package main.java.com.pluralsight.advancedjava.examples.example01;

import java.math.BigDecimal;

public record DiscountOrderLine(String discountCode, BigDecimal amount) implements OrderLine {
}
