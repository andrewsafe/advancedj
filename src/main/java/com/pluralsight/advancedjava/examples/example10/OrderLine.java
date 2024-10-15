package main.java.com.pluralsight.advancedjava.examples.example10;

import main.java.com.pluralsight.advancedjava.examples.example05.Product;

import java.math.BigDecimal;

import static main.java.com.pluralsight.advancedjava.examples.example05.Validation.checkThat;

public record OrderLine(Product product, int quantity, BigDecimal price) {

    public OrderLine {
        checkThat(product != null, "product must not be null");
        checkThat(price != null, "price must not be null");
    }

    public OrderLine withQuantity(int newQuantity) {
        return new OrderLine(product, newQuantity, price);
    }

    public OrderLine withPrice(BigDecimal newPrice) {
        return new OrderLine(this.product, this.quantity, newPrice);
    }
}
