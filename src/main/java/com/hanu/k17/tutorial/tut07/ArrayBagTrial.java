package com.hanu.k17.tutorial.tut07;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class ArrayBagTrial implements Runnable {
    private static final Logger LOGGER = Logger.getLogger("ArrayBagTrial");

    public static void main(String[] args) {
        new ArrayBagTrial().run();
        BagInterface<Integer> bag = new ArrayBag<Integer>();
        bag.add(0); LOGGER.info(bag.toString());
        bag.add(1); LOGGER.info(bag.toString());
        bag.add(10000); LOGGER.info(bag.toString());
        bag.add(10000); LOGGER.info(bag.toString());
        bag.remove(); LOGGER.info(bag.toString());
        bag.remove(10000); LOGGER.info(bag.toString());

    }

    public void run() {
        int successfulTestCnt = 0;
        
        List<ThrowableRunnable> tests = new LinkedList<>();
        List<ThrowableRunnable> failedTests = new LinkedList<>();

        tests.add(this::testInit);
        tests.add(this::testAdd);
        tests.add(this::testRemove);
        for (ThrowableRunnable test : tests) {
            Exception e = runTestAndGetException(test);
            if (e != null)
                failedTests.add(test);
            else
                successfulTestCnt++;
        }
        LOGGER.info("Passed tests: " + successfulTestCnt);
        if (!failedTests.isEmpty()) {
            LOGGER.info("Failed tests: " + failedTests.toString());
        }
    }

    Exception runTestAndGetException(ThrowableRunnable test) {
        try {
            test.invoke();
        } catch (Exception e) {
            return e;
        }
        return null;
    }

    @SuppressWarnings({ "unused", "rawtypes" })
    void testInit() throws Exception {
        try {
            BagInterface bag = new ArrayBag();
            BagInterface<Integer> intBag = new ArrayBag<>();
            assertBagCapacity((ArrayBag) bag, 30);
            BagInterface bagWithInitCap = new ArrayBag(100);
            BagInterface<Integer> intBagWithInitCap = new ArrayBag<>(100);
            assertBagCapacity((ArrayBag) bag, 30);
            try {
                BagInterface bagWithInvalidCap = new ArrayBag(10000);
                BagInterface<Integer> intBagWithInvalidCap = new ArrayBag<>(10000);
                throw new IllegalStateException();
            } catch (IllegalArgumentException e) {

            }
        } catch (Exception e) {
            throw new Exception();
        }
    }

    @SuppressWarnings("rawtypes")
    void testAdd() throws Exception {
        BagInterface<Comparable> bag = new ArrayBag<>();
        Comparable<?>[] successfulCases = { new String(), new Integer(0) };
        for (int i = 0; i < 30; i++) {
            if (!bag.add(successfulCases[i % 2])) {
                throw new Exception();
            }
            assertBagSize((ArrayBag) bag, i + 1);
            assertBagSize((ArrayBag) bag, bag.getCurrentSize());
        }
        if (bag.add(new String())) {
            throw new Exception();
        }

        BagInterface<Comparable> _bag = new ArrayBag<>();
        try {
            _bag.add(null);
            throw new Exception();
        } catch (NullPointerException e) {

        }
    }

    @SuppressWarnings("rawtypes")
    void testRemove() throws Exception {
        BagInterface<Comparable> bag = new ArrayBag<>();
        Comparable<?>[] successfulCases = { new String(), new Integer(0) };
        for (int i = 0; i < 2; i++) {
            bag.add(successfulCases[i % 2]);
        }

        // remove:
        bag.remove(successfulCases[0]);
        assertBagSize((ArrayBag) bag, 1);
        bag.remove(null);
        assertBagSize((ArrayBag) bag, 1);
        bag.remove();
        assertEmpty((ArrayBag) bag);
    }

    void assertEmpty(ArrayBag<?> bag) throws Exception {
        if (!bag.isEmpty()) {
            throw new Exception();
        }
    }

    void assertBagSize(ArrayBag<?> bag, int expectedCap)
            throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        Field f = bag.getClass().getDeclaredField("bag");
        f.setAccessible(true);
        Object[] backingBag = (Object[]) f.get(bag);
        int actualCap = 0;
        for (Object o : backingBag) {
            if (o != null)
                ++actualCap;
        }
        if (actualCap != expectedCap) {
            throw new IllegalStateException();
        }
    }

    void assertBagCapacity(ArrayBag<?> bag, int expectedCap)
            throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        Field f = bag.getClass().getDeclaredField("bag");
        f.setAccessible(true);
        Object[] backingBag = (Object[]) f.get(bag);
        int actualCap = backingBag.length;
        if (actualCap != expectedCap) {
            throw new IllegalStateException();
        }
    }
}

@FunctionalInterface
interface ThrowableRunnable {
    void invoke() throws Exception;
}