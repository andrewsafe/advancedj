package main.java.com.pluralsight.advancedjava.examples.example01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdasExample01 {

    public static void main(String[] args) {
        var names = new ArrayList<>(List.of("Andrew", "Tyler", "Mahdy", "Taimur"));

        names.sort(new Comparator<String>() {
            @Override
            public int compare(String first, String second) {
                return Integer.compare(first.length(), second.length());
            }
        });

        names.sort((first, second) -> Integer.compare(first.length(), second.length()));

        System.out.println(names);
    }
}
