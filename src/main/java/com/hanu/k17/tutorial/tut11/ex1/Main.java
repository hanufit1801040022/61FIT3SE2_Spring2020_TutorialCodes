package com.hanu.k17.tutorial.tut11.ex1;

public class Main {
    public static void main(String[] args) {
        String[] names = { null, "", "a", "LongerName"};
        int[] ages = {-1, 0, 1, 15, 20};
        for (String name : names) {
            for (int age : ages) {
                try {
                    tryCreatePersonInstance(name, age);
                    tryCreateChildInstance(name, age);
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getClass().getSimpleName() + ": " + e.getMessage());
                }
            }
        }
    }

    static void tryCreatePersonInstance(String name, int age) {
        System.out.printf("+-- Creating a Person with name=%s, age=%d: ", name, age);
        Person p = new Person(name, age);
        System.out.println(p);
    }

    static void tryCreateChildInstance(String name, int age) {
        System.out.printf("+-- Creating a Child with name=%s, age=%d: ", name, age);
        Person p = new Child(name, age);
        System.out.println(p);
    }
}