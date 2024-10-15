package main.java.com.pluralsight.advancedjava.examples.example01;

import main.java.com.pluralsight.advancedjava.examples.example05.Customer;
import main.java.com.pluralsight.advancedjava.examples.example05.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SealedExample02 {

    public static void main(String[] args) {
        var customer = new Customer(500567L, "Joe Smith", "joe.smith@example.com");
        var product = new Product(100123L, "Apples", "Tasty red apples");

        var order = new Order(200201L, customer, LocalDateTime.now(), List.of(
                new SalesOrderLine(product, 6, new BigDecimal("5.94")),
                new DiscountOrderLine("WELCOME", new BigDecimal("2.50"))));

        var orderService = new OrderService();
        var total = orderService.calculateTotalAmount(order);
        System.out.printf("Total amount: %s%n", total);
    }
}
