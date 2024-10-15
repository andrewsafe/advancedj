package main.java.com.pluralsight.advancedjava.examples.example01;

import java.math.BigDecimal;

public class OrderService {

    public BigDecimal calculateTotalAmount(Order order) {
        var total = BigDecimal.ZERO;

        for (OrderLine line : order.lines()) {
            if (line instanceof SalesOrderLine sale) {
                total = total.add(sale.amount());
            } else if (line instanceof DiscountOrderLine discount) {
                total = total.subtract(discount.amount());
            }
        }

            return total;
    }
}
