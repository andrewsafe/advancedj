package main.java.com.pluralsight.advancedjava.examples.example08;

import java.util.regex.Pattern;

import static main.java.com.pluralsight.advancedjava.examples.example05.Validation.checkThat;

public record EmailAddress(String value) {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(".+@.+\\..+");

    public EmailAddress {
        checkThat(value != null && !value.isBlank(), "value must not be null or blank");
        checkThat(EMAIL_PATTERN.matcher(value).matches(), "value is not a valid email address");
    }

    @Override
    public String toString() {
        return value;
    }
}
