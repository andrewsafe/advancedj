package main.java.com.pluralsight.advancedjava.examples.example01;

import java.time.LocalDate;

public class Enclosing {

    private static int number = 23;
    private static LocalDate date = LocalDate.of(2024, 10, 11);

    private static String name = "Joe Smith";

    private static void printNumber() {
//        System.out.println(name);
        System.out.println(number);
    }

    private static void printDate() {
        System.out.println(date);
    }

    public static void printName() {
        System.out.println(name);
    }

    static class Nested {
        private LocalDate date = LocalDate.of(2023, 7, 10);

        private void printDate() {
            System.out.println(date);
        }

        void run() {
            System.out.println(date); //date in class Nested
            printDate(); // printDate() in class Nested

            System.out.println(Enclosing.date);
            printNumber();

            // Accessing static members of the enclosing class is OK
            System.out.println(number);
            printNumber();

            // Accessing the instance members of the enclosing class does not work
//            System.out.println(name);
//            printNumber();
        }
    }
}
