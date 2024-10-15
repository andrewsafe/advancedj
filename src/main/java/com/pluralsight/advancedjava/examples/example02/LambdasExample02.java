package main.java.com.pluralsight.advancedjava.examples.example02;

import java.util.List;

public class LambdasExample02 {

    public static void main(String[] args) {
        var names = List.of("And Rew", "Rew And", "wand re");

        var count = 0;
        for (String name : names) {
            System.out.println(++count + ": " + name);
        }

//        Error: local variables referenced from a lambda expression must be final or effectively final
//        names.forEach(name -> System.out.println(++count + ": " + name));
    }
}
