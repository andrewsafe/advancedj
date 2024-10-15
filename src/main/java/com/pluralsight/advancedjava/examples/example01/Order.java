package main.java.com.pluralsight.advancedjava.examples.example01;

import main.java.com.pluralsight.advancedjava.examples.example05.Customer;

import java.time.LocalDateTime;
import java.util.List;

public record Order(long id, Customer customer, LocalDateTime dateTime, List<OrderLine> lines) {
}
