package main.java.com.pluralsight.advancedjava.examples.example11;

import main.java.com.pluralsight.advancedjava.examples.example05.Customer;
import main.java.com.pluralsight.advancedjava.examples.example05.Product;
import main.java.com.pluralsight.advancedjava.examples.example10.OrderLine;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RecordsExample11 {

    public static void main(String[] args) {
        var product1 = new Product(100123L, "James", "Bounty: 1 bil berry");
        var product2 = new Product(100346L, "Sikander", "Bounty: 5 dollars");

        var customer = new Customer(500567L, "Adam", "adam@gmail.com");

        var order = new Order(200201L, customer, LocalDateTime.now())
                .withLine(new OrderLine(product1, 6, new BigDecimal("2.45")))
                .withLine(new OrderLine(product2, 2, new BigDecimal("2.56")));
    }
}
