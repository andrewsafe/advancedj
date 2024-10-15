package main.java.com.pluralsight.advancedjava.examples.example09;

import main.java.com.pluralsight.advancedjava.examples.example05.Product;
import main.java.com.pluralsight.advancedjava.examples.example05.Customer;
import main.java.com.pluralsight.advancedjava.examples.example05.OrderLine;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class RecordsExample09 {

    public static void main(String[] args) {
        var product1 = new Product(100123L, "Andrew", "next up");
        var product2 = new Product(100124L, "Rust", "lil");

        var customer = new Customer(500567L, "Andrew S", "andrew@gmail.com");

        var order1 = new Order(200201L, customer, LocalDateTime.now(), List.of(
                new OrderLine(product1, 6, new BigDecimal("5.94")),
                new OrderLine(product2, 2, new BigDecimal("2.50"))));

        var order2 = Order.builder()
                .withId(200201L)
                .forCustomer(customer)
                .atDateTime(LocalDateTime.now())
                .addLine(new OrderLine(product1, 6, new BigDecimal("5.94")))
                .addLine(new OrderLine(product2, 2, new BigDecimal("2.50")))
                .build();
    }
}
