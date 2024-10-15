package main.java.com.pluralsight.advancedjava.examples.example03;

import main.java.com.pluralsight.advancedjava.examples.example01.DiscountOrderLine;
import main.java.com.pluralsight.advancedjava.examples.example01.Order;
import main.java.com.pluralsight.advancedjava.examples.example01.SalesOrderLine;
import main.java.com.pluralsight.advancedjava.examples.example01.OrderLine;

import java.math.BigDecimal;

public class OrderService {

    public BigDecimal calculateTotalAmount(Order order) {
        var total = BigDecimal.ZERO;

        for (OrderLine line : order.lines()) {
            var netAmount = switch (line) {
                case SalesOrderLine sale -> total = total.add(sale.amount());
                case DiscountOrderLine discount -> total = total.subtract(discount.amount());
            };

            total = total.add(netAmount);
        }

        return total;
    }
}
