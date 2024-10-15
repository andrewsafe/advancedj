package main.java.com.pluralsight.advancedjava.examples.example03;

import java.util.ArrayList;
import java.util.List;

public class LambdasExample03 {

    public static void main(String[] args) {
        var names = List.of("and rew", "rew and", "drew an");

        var result1 = new ArrayList<String>();
        for (String name : names) {
            result1.add(name.toUpperCase());
        }

        var result2 = new ArrayList<String>();
        names.forEach(name -> result2.add(name.toUpperCase())); // Lambda expression with a side effect

        var result3 = names.stream().map(name -> name.toUpperCase()).toList();

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
