package com.hanu.k17.tutorial.tut11.ex3;

import java.util.regex.Pattern;

public abstract class Human {
    private static final Pattern NAME_REGEX = Pattern.compile("^[A-Z]([a-z]{3,})$");

    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        throwExceptionIfInvalidName(firstName);
        throwExceptionIfInvalidName(lastName);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    protected void throwExceptionIfInvalidName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name is null!");
        }
        if (!NAME_REGEX.matcher(name).matches()) {
            throw new IllegalArgumentException("Name is invalid!");
        }
    }

    public abstract void printInfo();
}