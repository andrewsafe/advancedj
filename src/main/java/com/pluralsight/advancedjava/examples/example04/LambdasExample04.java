package main.java.com.pluralsight.advancedjava.examples.example04;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class LambdasExample04 {

    public static void main(String[] args) {
        var names = List.of("and rew", "rew and", "drew an");

        try (FileWriter out = new FileWriter("names.txt", StandardCharsets.UTF_8)) {
            for (String name : names) {
                out.write(name + "\n");
            }

            names.forEach(name -> {
                try {
                    out.write(name + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e); // Wrap it in an unchecked RuntimeException - Not recommended
                }
            });
        } catch (IOException | RuntimeException e) {
            System.out.println("An error occurred : " + e.getMessage());
        }
    }
}
