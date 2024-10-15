package main.java.com.pluralsight.advancedjava.examples.example02;

import main.java.com.pluralsight.advancedjava.examples.example01.DiscountOrderLine;
import main.java.com.pluralsight.advancedjava.examples.example01.Order;
import main.java.com.pluralsight.advancedjava.examples.example01.OrderLine;
import main.java.com.pluralsight.advancedjava.examples.example01.SalesOrderLine;

import java.math.BigDecimal;

public class OrderService {

    public boolean hasSaleWithAmountGreaterThan(Order order, BigDecimal limit) {
        for (OrderLine line : order.lines()) {
            if (line instanceof SalesOrderLine sale && sale.amount().compareTo(limit) > 0) {
                return true;
            }
        }
        return false;
    }

    public BigDecimal calculateTotalDiscount(Order order) {
        var total = BigDecimal.ZERO;

        for (OrderLine line : order.lines()) {
            if (!(line instanceof DiscountOrderLine discount)) {
                continue;
            }

            total = total.add(discount.amount());
        }

        return total;
    }
    public BigDecimal calculateTotalAmount(Order order) {
        var total = BigDecimal.ZERO;

        for (OrderLine line : order.lines()) {
            if (line instanceof SalesOrderLine sale) {
                total = total.add(sale.amount());
            } else if (line instanceof DiscountOrderLine discount) {
                total = total.add(discount.amount());
            }
        }

        return total;
    }
}