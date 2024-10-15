package main.java.com.pluralsight.advancedjava.examples.example08;

import static main.java.com.pluralsight.advancedjava.examples.example05.Validation.checkThat;

public record NickName(String value) {

    public NickName {
        checkThat(value != null && !value.isBlank(), "value must not be null or empty");
    }

    @Override
    public String toString() {
        return value;
    }
}
