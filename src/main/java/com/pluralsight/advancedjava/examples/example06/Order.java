package main.java.com.pluralsight.advancedjava.examples.example06;

import main.java.com.pluralsight.advancedjava.examples.example05.OrderLine;
import main.java.com.pluralsight.advancedjava.examples.example05.Customer;

import java.time.LocalDateTime;
import java.util.List;

import static main.java.com.pluralsight.advancedjava.examples.example05.Validation.checkThat;

public record Order(long id, Customer customer, LocalDateTime dateTime, List<OrderLine> lines) {

    public Order {
        checkThat(customer != null, "customer must not be null");
        checkThat(dateTime != null, "dateTime must not be null");
        checkThat(lines != null && !lines.isEmpty(), "lines must not be null");

        lines = List.copyOf(lines);
    }
}
