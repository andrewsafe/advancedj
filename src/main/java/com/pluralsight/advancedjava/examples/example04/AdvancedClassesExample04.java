package main.java.com.pluralsight.advancedjava.examples.example04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AdvancedClassesExample04 {

    public static void main(String[] args) {
        var names = new ArrayList<>(List.of("Andrew", "Tyler", "Mahdy", "Taimur", "Sam", "Aaron"));

        names.sort(new Comparator<String>() {
            @Override
            public int compare(String first, String second) {
                return Integer.compare(first.length(), second.length());
            }
        });

        names.sort(Comparator.comparingInt(String::length));

        System.out.println(names);
    }
}
