package main.java.com.pluralsight.advancedjava.examples.example11;

import main.java.com.pluralsight.advancedjava.examples.example05.Customer;
import main.java.com.pluralsight.advancedjava.examples.example10.OrderLine;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static main.java.com.pluralsight.advancedjava.examples.example05.Validation.checkThat;

public record Order(long id, Customer customer, LocalDateTime dateTime, List<OrderLine> lines) {

    public Order {
        checkThat(customer != null, "customer must not be null");
        checkThat(dateTime != null, "dateTime must not be null");
        checkThat(lines != null, "lines must not be null");

        lines = List.copyOf(lines);
    }

    public Order(long id, Customer customer, LocalDateTime dateTime) {
        this(id, customer, dateTime, Collections.emptyList());
    }

    public Order withLine(OrderLine line) {
        var newLines = new ArrayList<OrderLine>(this.lines);
        newLines.add(line);
        return new Order(this.id, this.customer, this.dateTime, newLines);
    }
}
