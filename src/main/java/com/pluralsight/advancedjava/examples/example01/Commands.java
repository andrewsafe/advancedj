package main.java.com.pluralsight.advancedjava.examples.example01;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Commands {

    Command[] value();
}
