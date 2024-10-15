package main.java.com.pluralsight.advancedjava.examples.example12;

public class AdvancedGenericsExample12 {

    public static void main(String[] args) {
//        Pair<Integer, String>[] pairs = new Pair<Integer, String>[10]; // Error: generic array creation

        Dog[] dogs = new Dog[2];
        dogs[0] = new Dog("Pluto");
        dogs[1] = new Dog("Luna");

        Animal[] animals = dogs; // OK because arrays are covariant: Dog[] is a subtype of Animal[]

        animals[0] = new Cat("Lun1"); // ArrayStoreException

        // The array store check needs runtime type information which is not available for non-reifiable types
        // Therefore, creating arrays with elements of a non-reifiable type is not allowed

        Dog luna = dogs[0]; // ?
    }

//    static <T> T[] createArray(int size) {
//        return new T[size]; // Error: generic array creation
//    }
}

record Pair<T, U>(T first, U second) {}

interface Animal {}
record Dog(String name) implements Animal {}
record Cat(String name) implements Animal {}