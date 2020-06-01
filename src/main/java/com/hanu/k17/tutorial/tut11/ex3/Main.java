package com.hanu.k17.tutorial.tut11.ex3;

public class Main {
    public static void main(String[] args) {
        String[] names = { null, "", "A", "aaa", "epic", "Molotov" };

        // test for student
        String[] facultyNumbers = { null, "", "a128", "FIT123", "FIT20202020" };
        for (String firstName : names) {
            for (String lastName : names) {
                for (String facultyNumber : facultyNumbers) {
                    testCreateStudent(firstName, lastName, facultyNumber);
                }
            }
        }

        // test for worker
        int[] workHours = {0, 1, 5, 12, 13};
        double[] weekSalaries = {0.0d, 10.0d, 133.33d};
        for (String firstName : names) {
            for (String lastName : names) {
                for (int hoursPerDay : workHours) {
                    for (double weekSalary : weekSalaries) {
                        testCreateWorker(firstName, lastName, weekSalary, hoursPerDay);
                    }
                }
            }
        }
    }

    static void testCreateStudent(String firstName, String lastName, String facultyNumber) {
        try {
            System.out.printf("+-- Test create Student for firstName=%s, lastName=%s, facultyNumber=%s%n", firstName, lastName, facultyNumber);
            Student s = new Student(firstName, lastName, facultyNumber);
            s.printInfo();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    static void testCreateWorker(String firstName, String lastName, double weekSalary, int hoursPerDay) {
        try {
            System.out.printf("+-- Test create Worker for firstName=%s, lastName=%s, weekSalary=%.2f, hoursPerDay=%d%n", firstName, lastName, weekSalary, hoursPerDay);
            Human w = new Worker(firstName, lastName, weekSalary, hoursPerDay);
            w.printInfo();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}