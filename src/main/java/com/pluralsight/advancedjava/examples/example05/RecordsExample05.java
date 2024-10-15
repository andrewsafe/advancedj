package main.java.com.pluralsight.advancedjava.examples.example05;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class RecordsExample05 {

    public static void main(String[] args) {
        var product1 = new Product(100123L, "MasterChief", "Spartan 117");
        var product2 = new Product(100456L, "Cortana", "Aritifical Intelligence Assistant");

        var customer = new Customer(500567L, "Andrew", "andrew@gmail.com");

        var lines = new ArrayList<OrderLine>();
        lines.add(new OrderLine(product1, 6, new BigDecimal("6.23")));
        lines.add(new OrderLine(product2, 3, new BigDecimal("2.50")));

        var order = new Order(200201L, customer, LocalDateTime.now(), lines);
        System.out.println(order);

        var orderLine = new OrderLine(new Product(100892L, "Banana Pancakes", "Golden"), 3, new BigDecimal("5.00"));
        lines.add(orderLine);
        System.out.println(order);
    }
}
