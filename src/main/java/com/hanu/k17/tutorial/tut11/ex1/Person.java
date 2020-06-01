package com.hanu.k17.tutorial.tut11.ex1;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        throwExceptionIfInvalidName(name);
        throwExceptionIfInvalidAge(age);
        this.name = name;
        this.age = age;
    }

    protected void throwExceptionIfInvalidName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name is null!");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Name must contain more than 3 characters!");
        }
    }

    protected void throwExceptionIfInvalidAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age must not be less than 0!");
        }
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        throwExceptionIfInvalidAge(age);
        this.age = age;
    }

    public void setName(String name) {
        throwExceptionIfInvalidName(name);
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName())
            .append("<")
            .append("name=").append(this.name)
            .append(",")
            .append("age=").append(this.age)
            .append(">");
        return sb.toString();
    }
}