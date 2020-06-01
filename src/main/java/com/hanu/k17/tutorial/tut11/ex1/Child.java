package com.hanu.k17.tutorial.tut11.ex1;

public class Child extends Person {

    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    protected void throwExceptionIfInvalidAge(int age) {
        if (age > 15) {
            throw new IllegalArgumentException("A child cannot be older than 15 years old!");
        }
        super.throwExceptionIfInvalidAge(age);
    }
    
}