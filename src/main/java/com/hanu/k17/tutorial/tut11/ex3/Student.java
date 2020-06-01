package com.hanu.k17.tutorial.tut11.ex3;

import java.util.regex.Pattern;

public class Student extends Human {
    private static final Pattern FACULTY_NUMBER_REGEX = Pattern.compile("[A-Za-z0-9]{5,10}");

    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        throwExceptionIfInvalidFacultyNumber(facultyNumber);
        this.facultyNumber = facultyNumber;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        throwExceptionIfInvalidFacultyNumber(facultyNumber);
        this.facultyNumber = facultyNumber;
    }

    protected void throwExceptionIfInvalidFacultyNumber(String facultyNumber) {
        if (facultyNumber == null) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        if (!FACULTY_NUMBER_REGEX.matcher(facultyNumber).matches()) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }
    }

    public void printInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("First Name: %s", getFirstName())).append("\n")
            .append(String.format("Last Name: %s", getLastName())).append("\n")
            .append(String.format("Faculty Number: %s", facultyNumber)).append("\n");
        System.out.println(sb);
    }
}