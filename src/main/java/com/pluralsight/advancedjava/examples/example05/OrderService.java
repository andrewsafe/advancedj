//package main.java.com.pluralsight.advancedjava.examples.example05;
//
//import main.java.com.pluralsight.advancedjava.examples.example01.DiscountOrderLine;
//import main.java.com.pluralsight.advancedjava.examples.example01.SalesOrderLine;
//
//import java.math.BigDecimal;
//
//public class OrderService {
//
//    public String formatShippingAddress(Customer customer) {
////        return String.format("%s%n%s %s%n%s%n%s%n", customer.name(), customer.shippingAddress().street(),
////                customer.shippingAddress().houseNumber(), customer.shippingAddress().city(), customer.shippingAddress().country());
//        return switch (customer) {
//            case Customer(var id, var name, var email, Address(var street, var houseNumber, var city, var country)) ->
//                    String.format("%s%n%s %s%n%s%n%s%n", name, street, houseNumber, city, country);
//        };
//    }
//
//    public BigDecimal calculateTotalAmount(Order order) {
//        var total = BigDecimal.ZERO;
//
//        for (OrderLine line : order.lines()) {
//            var netAmount = switch (line) {
//                case SalesOrderLine(var product, var quantity, var amount) -> amount;
//                case DiscountOrderLine(var discountCode, var amount) -> amount.negate();
//            };
//
//            total = total.add(netAmount);
//        }
//        return total;
//    }
//}
