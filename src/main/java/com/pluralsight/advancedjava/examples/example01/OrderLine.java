package main.java.com.pluralsight.advancedjava.examples.example01;

public sealed interface OrderLine permits SalesOrderLine, DiscountOrderLine {
}
