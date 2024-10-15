package main.java.com.pluralsight.advancedjava.examples.example10;

import java.util.ArrayList;
import java.util.List;

public class AdvancedGenericsExample10 {

    public static void main(String[] args) {
        List dogs = new ArrayList<>();
        dogs.add(new Dog("Doge"));
        dogs.add(new Dog("dog1"));

        List<Cat> cats = dogs; // Allowed!
        System.out.println(cats);

        Cat cat = cats.get(0); // ClassCastException
    }
}

interface Animal {}
record Dog(String name) implements Animal {}
record Cat(String name) implements Animal {}
