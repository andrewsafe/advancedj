package main.java.com.pluralsight.advancedjava.examples.example09;

import main.java.com.pluralsight.advancedjava.examples.example05.Customer;
import main.java.com.pluralsight.advancedjava.examples.example05.OrderLine;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static main.java.com.pluralsight.advancedjava.examples.example05.Validation.checkThat;

public record Order(long id, Customer customer, LocalDateTime dateTime, List<OrderLine> lines) {

    public Order {
        checkThat(customer != null, "customer must not be null");
        checkThat(dateTime != null, "dateTime must not be null");
        checkThat(lines != null && !lines.isEmpty(), "lines must not be null or empty");
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private long id;
        private Customer customer;
        private LocalDateTime dateTime;
        private List<OrderLine> lines = new ArrayList<>();

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder forCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder atDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Builder addLine(OrderLine line) {
            this.lines.add(line);
            return this;
        }

        public Order build() {
            return new Order(id, customer,dateTime,lines);
        }
    }
}
