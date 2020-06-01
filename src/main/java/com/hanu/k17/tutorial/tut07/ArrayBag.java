package com.hanu.k17.tutorial.tut07;

import java.util.Arrays;
import java.util.Random;

/**
 * A class of bags whose entries are stored in a fixed-size array.
 */
@SuppressWarnings("unchecked")
public final class ArrayBag<T extends Comparable<? super T>> implements BagInterface<T> {
    // STEP 1: DETERMINES THE DATA FIELDS
    /**
     * TO-DO: Declares the necessary attributes bag: [T] numberOfEntries: int
     * DEFAULT_CAPACITY: int (30) MAX_CAPACITY: int (3000)
     */
    private static final int DEFAULT_CAPACITY = 30;
    private static final int MAX_CAPACITY = 3000;

    private T[] bag;
    private int numberOfEntries;

    // STEP 2: IMPLEMENTS THE CONSTRUCTORS
    /**
     * TO-DO: Creates an empty bag whose initial capacity is 30.
     */
    public ArrayBag() {
        bag = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    /**
     * TO-DO: Creates an empty bag having a given capacity.
     *
     * @param desiredCapacity The integer capacity desired.
     */
    public ArrayBag(int desiredCapacity) {
        if (desiredCapacity > MAX_CAPACITY || desiredCapacity < 0) {
            throw new IllegalArgumentException("desiredCapacity is invalid!");
        }
        bag = (T[]) new Comparable[desiredCapacity];
    }

    // STEP 3: IMPLEMENTS THE FUNCTIONS
    /**
     * TO-DO: Adds a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, or false if not.
     */
    public boolean add(T newEntry) {
        if (newEntry == null) {
            throw new NullPointerException();
        }
        if (!isArrayFull()) {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
            return true;
        }
        return false;
    }

    /**
     * TO-DO: Retrieves all entries that are in this bag.
     *
     * @return A newly allocated array of all the entries in this bag.
     */
    public T[] toArray() {
        T[] array = (T[]) new Comparable[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            array[i] = bag[i];
        }
        return array;
    }

    /**
     * TO-DO: Sees whether this bag is empty.
     *
     * @return True if this bag is empty, or false if not.
     */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**
     * TO-DO: Gets the current number of entries in this bag.
     *
     * @return The integer number of entries currently in this bag.
     */
    public int getCurrentSize() {
        return numberOfEntries;
    }

    /**
     * TO-DO: Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in this bag.
     */
    public int getFrequencyOf(T anEntry) {
        int freq = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                freq++;
            }
        }
        return freq;
    }

    /**
     * TO-DO: Tests whether this bag contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if this bag contains anEntry, or false otherwise.
     */
    public boolean contains(T anEntry) {
        for (T item : bag) {
            if (item.equals(anEntry)) {
                return true;
            }
        }
        return false;
    }

    /**
     * TO-DO: Removes all entries from this bag.
     */
    public void clear() {
        bag = (T[]) new Comparable[DEFAULT_CAPACITY];
        numberOfEntries = 0;
    }

    /**
     * TO-DO: Removes one unspecified entry from this bag, if possible.
     *
     * @return Either the removed entry, if the removal was successful, or null.
     */
    public T remove() {
        // removing the last element
        if (numberOfEntries == 0) {
            return null;
        }
        Random rd = new Random();
        int randomIndexToRemove = rd.nextInt(numberOfEntries);
        return removeEntry(randomIndexToRemove);
    }

    /**
     * TO-DO: Removes one occurrence of a given entry from this bag.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry) {
        if (isEmpty()) return false;
        int indexOfEntry = getIndexOf(anEntry);
        if (indexOfEntry < 0) {
            return false;
        }
        return removeEntry(indexOfEntry) != null;
    }

    // TO-DO: Returns true if the array bag is full, or false if not.
    private boolean isArrayFull() {
        return bag.length == numberOfEntries;
    }

    // TO-DO: Locates a given entry within the array bag.
    // Returns the index of the entry, if located,
    // or -1 otherwise.
    // Precondition: checkInitialization has been called.
    private int getIndexOf(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                return i;
            }
        }
        return -1;
    }

    // TO-DO: Removes and returns the entry at a given index within the array.
    // If no such entry exists, returns null.
    // Precondition: 0 <= givenIndex < numberOfEntries.
    // Precondition: checkInitialization has been called.
    private T removeEntry(int givenIndex) {
        if (givenIndex < 0 || givenIndex >= numberOfEntries) {
            throw new IllegalArgumentException("The givenIndex is not present in the bag!");
        }
        T tmp = bag[givenIndex];
        for (int i = givenIndex; i < numberOfEntries; i++) {
            bag[i] = bag[i + 1];
        }
        numberOfEntries--;
        bag[numberOfEntries] = null;
        return tmp;
    }

    @Override
    public String toString() {
        return getClass().getName() + ":" + Arrays.toString(bag).replace(", null", "");
    }
}
