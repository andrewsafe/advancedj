package main.java.com.pluralsight.advancedjava.examples.example07;

import java.util.ArrayList;
import java.util.List;

public class AdvancedGenericsExample07 {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Pluto"));
        dogs.add(new Dog("Luna"));

        Animal animal = new Dog("Max");

        // A List that can contain any kind of object of type Animal
        // List<Animal> animals = dogs; // Error! Generic types are invariant

        // A List of objects of a particular, but unknown type that extends Animal
        List<? extends Animal> animals = dogs;
    }
}

interface Animal {}
record Dog(String name) implements Animal {}
record Cat(String name) implements Animal {}
