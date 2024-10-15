package main.java.com.pluralsight.advancedjava.examples.example03;

public class AdvancedGenericsExample03 {

    public static void main(String[] args) {
        var p1 = Pair.<Integer, String>of(1, "none");

        var p2 = Pair.of(2, "two");

        var p3 = p2.map((left, right) -> Pair.of(right, left));

        var p4 = p2.<String, Integer>map((Integer left, String right) -> Pair.<String, Integer>of(right, left));
    }
}
