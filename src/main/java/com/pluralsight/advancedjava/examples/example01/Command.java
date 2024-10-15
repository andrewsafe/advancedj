package main.java.com.pluralsight.advancedjava.examples.example01;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Repeatable(Commands.class)
public @interface Command {

    String value();

    String description() default ""; // null is not allowed

    int order() default 0;

    // Allowed element types:
    // - primitive type, String, enum type, java.lang.Class, annotation type
    // - an array of one of the above

    // Element values must be compile-time constants
}
