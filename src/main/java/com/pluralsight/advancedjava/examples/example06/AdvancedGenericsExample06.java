package main.java.com.pluralsight.advancedjava.examples.example06;

import java.util.ArrayList;
import java.util.List;

public class AdvancedGenericsExample06 {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog("Pluto"));
        dogs.add(new Dog("Luna"));

//        List<Animal> animals = dogs; - Error!

    }
}

interface Animal {}
record Dog(String name) implements Animal {}
record Cat(String name) implements Animal {}
