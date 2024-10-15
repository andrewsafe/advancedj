package main.java.com.pluralsight.advancedjava.examples.example05;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static main.java.com.pluralsight.advancedjava.examples.example05.Validation.checkThat;

public record Order(long id, Customer customer, LocalDateTime dateTime, ArrayList<main.java.com.pluralsight.advancedjava.examples.example05.OrderLine> lines) {

    public Order(long id, Customer customer, LocalDateTime dateTime, ArrayList<main.java.com.pluralsight.advancedjava.examples.example05.OrderLine> lines) {
        checkThat(customer != null, "customer must not be null");
        checkThat(dateTime != null, "customer must not be null");
        checkThat(lines != null && !lines.isEmpty(), "lines must not be null or empty");

        this.id = id;
        this.customer = customer;
        this.dateTime = dateTime;
        this.lines = (ArrayList<OrderLine>) List.copyOf(lines); // Defensive unmodifiable copy
    }

    // Rules:
    // - The canonical constructor's access level cannot be more restrictive than that of the record itself
    // - The canonical consturctor cannot have a 'throws' clause
}
