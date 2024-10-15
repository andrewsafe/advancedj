package main.java.com.pluralsight.advancedjava.examples.example08;

import java.util.regex.Pattern;

import static main.java.com.pluralsight.advancedjava.examples.example05.Validation.checkThat;

public record Customer1(long id, String firstName, String lastName, String nickName, String email) {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(".+@.+\\..+");

    public Customer1 {
        checkThat(firstName != null && !firstName.isBlank(), "firstName must not be null or blank");
        checkThat(lastName != null && !lastName.isBlank(), "lastName must not be null or blank");
        checkThat(nickName != null && !nickName.isBlank(), "nickName must not be null or blank");
        checkThat(email != null && !email.isBlank(), "email must not be null or blank");
        checkThat(EMAIL_PATTERN.matcher(email).matches(), "not a valid email address");
    }
}
