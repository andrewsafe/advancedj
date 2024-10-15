package main.java.com.pluralsight.advancedjava.examples.example11;

import java.util.ArrayList;
import java.util.List;

public class AdvancedGenericsExample11 {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Pluto"));
        dogs.add(new Dog("Luna"));

        List<? extends Animal> animals = dogs;

        List<Dog> dogsAgain = (List<Dog>) animals; // Casting to a non-reifiable type: "unchecked" warning

        List<Cat> cats = (List<Cat>) animals; // "unchecked" warning and heap pollution
        Cat cat = cats.get(0); // ClassCastException
    }
}

interface Animal {}
record Dog(String name) implements Animal {}
record Cat(String name) implements Animal {}
