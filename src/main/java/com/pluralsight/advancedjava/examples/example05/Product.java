package main.java.com.pluralsight.advancedjava.examples.example05;

public record Product(long id, String name, String description) implements HasId, HasName {
}
