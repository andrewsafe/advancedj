package main.java.com.pluralsight.advancedjava.examples.example04;

import main.java.com.pluralsight.advancedjava.examples.example01.DiscountOrderLine;
import main.java.com.pluralsight.advancedjava.examples.example01.Order;
import main.java.com.pluralsight.advancedjava.examples.example01.OrderLine;
import main.java.com.pluralsight.advancedjava.examples.example01.SalesOrderLine;

public class OrderService {

    public String formatOrderLines(Order order) {
        var sb = new StringBuilder();

        for (OrderLine line : order.lines()) {
            var text = switch (line) {
                case SalesOrderLine sale when sale.quantity() == 1 ->
                    String.format("%-20s %8s%n", sale.product().name(), sale.amount());
                case SalesOrderLine sale ->
                    String.format("%-14s (%3d) %8s%n", sale.product().name(), sale.quantity(), sale.amount());
                case DiscountOrderLine discount ->
                    String.format("Discount %-8s     %8s%n", discount.discountCode(), discount.amount().negate());
            };

            sb.append(text);
        }

        return sb.toString();
    }
}
