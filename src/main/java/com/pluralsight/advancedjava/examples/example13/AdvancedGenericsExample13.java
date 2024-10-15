package main.java.com.pluralsight.advancedjava.examples.example13;

import java.util.HashMap;
import java.util.Map;

public class AdvancedGenericsExample13 {

    static void printLines(String... lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }

    @SafeVarargs
    static <T, U> void putIntoMap(Map<? super T, ? super U> map, Pair<? extends T, ? extends U>... pairs) {
        for (var pair : pairs) {
            map.put(pair.first(), pair.second());
        }

        Object[] array = pairs; // Allowed because arrays are covariant
        array[0] = new Pair<Long, Long>(2L, 3L); // The array store check will not be able to check this type - Heap Pollution
    }

    public static void main(String[] args) {
        printLines("500k", "how bout now");
        printLines(new String[]{"hard work pays off", "we chillin"});

        var map = new HashMap<Integer, String>();

        // The compiler creates an array of the non-reifiable type Pair<Integer, String> !!!
        putIntoMap(map, new Pair<>(1, "one"), new Pair<>(2, "two"));
    }
}

record Pair<T, U>(T first, U second) {}
