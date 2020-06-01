package com.hanu.k17.tutorial.tut11.ex3;

import java.util.regex.Pattern;

public class Worker extends Human {
    private static final Pattern NAME_REGEX = Pattern.compile("^[A-Z]([a-z]{2,})$");

    private double weekSalary;
    private int hoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, int hoursPerDay) {
        super(firstName, lastName);
        throwExceptionIfInvalidWeekSalary(weekSalary);
        throwExceptionIfInvalidHoursPerDay(hoursPerDay);
        this.hoursPerDay = hoursPerDay;
        this.weekSalary = weekSalary;
    }

    public double getWeekSalary() {
        return weekSalary;
    }

    public int getHoursPerDay() {
        return hoursPerDay;
    }

    public void setWeekSalary(double weekSalary) {
        throwExceptionIfInvalidWeekSalary(weekSalary);
        this.weekSalary = weekSalary;
    }

    public void setHoursPerDay(int hoursPerDay) {
        throwExceptionIfInvalidHoursPerDay(hoursPerDay);
        this.hoursPerDay = hoursPerDay;
    }

    @Override
    protected void throwExceptionIfInvalidName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name is null!");
        }
        if (!NAME_REGEX.matcher(name).matches()) {
            throw new IllegalArgumentException("Name is invalid!");
        }
    }

    protected void throwExceptionIfInvalidWeekSalary(double weekSalary) {
        if (weekSalary < 10) {
            throw new IllegalArgumentException("Invalid week salary!");
        }
    }

    protected void throwExceptionIfInvalidHoursPerDay(int hoursPerDay) {
        if (hoursPerDay < 1 || hoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
    }

    @Override
    public void printInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("First Name: %s", getFirstName())).append("\n")
            .append(String.format("Last Name: %s", getLastName())).append("\n")
            .append(String.format("Week salary: %.2f", weekSalary)).append("\n")
            .append(String.format("Hours per day: %d", hoursPerDay)).append("\n")
            .append(String.format("Salary per hour: %.2f", weekSalary / hoursPerDay));
        System.out.println(sb.toString());
    }
}