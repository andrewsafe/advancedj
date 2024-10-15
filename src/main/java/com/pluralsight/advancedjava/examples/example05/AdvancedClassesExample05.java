package main.java.com.pluralsight.advancedjava.examples.example05;

import java.io.IOException;
import java.util.Properties;

public class AdvancedClassesExample05 {

    private static final Properties CONFIGURATION = new Properties();

    static {
        try {
        CONFIGURATION.load(AdvancedClassesExample05.class.getResourceAsStream("/example.properties"));
    } catch (IOException e) {
        throw new RuntimeException(e);}
    }
}
