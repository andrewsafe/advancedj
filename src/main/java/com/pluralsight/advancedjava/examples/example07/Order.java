package main.java.com.pluralsight.advancedjava.examples.example07;

import main.java.com.pluralsight.advancedjava.examples.example05.Customer;
import main.java.com.pluralsight.advancedjava.examples.example05.OrderLine;

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

    public static Order createOrderAtCurrentDateTime(long id, Customer customer, List<OrderLine> lines) {
        return new Order(id, customer, LocalDateTime.now(), lines);
    }
}
