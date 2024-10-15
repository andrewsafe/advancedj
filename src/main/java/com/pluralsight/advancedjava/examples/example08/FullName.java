package main.java.com.pluralsight.advancedjava.examples.example08;

import static main.java.com.pluralsight.advancedjava.examples.example05.Validation.checkThat;

public record FullName(String firstName, String lastName) {

    public FullName {
        checkThat(firstName != null && !firstName.isBlank(), "firstName must not be null or blank");
        checkThat(lastName != null && !lastName.isBlank(), "lastName must not be null or blank");
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
