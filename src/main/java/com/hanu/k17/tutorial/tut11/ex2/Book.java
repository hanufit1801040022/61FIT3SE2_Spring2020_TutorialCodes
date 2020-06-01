package com.hanu.k17.tutorial.tut11.ex2;

import java.util.regex.Pattern;

public class Book {
    private static final Pattern AUTHOR_REGEX = Pattern.compile("^([A-Za-z]+(\\.{0,1}))( [A-Za-z]+(\\.{0,1})){0,2}$");

    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    protected void throwExceptionIfInvalidTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title is null!");
        }
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title must contain more than 3 characters!");   
        }
    }

    protected void throwExceptionIfInvalidAuthor(String author) {
        if (author == null) {
            throw new IllegalArgumentException("Author is null!");
        }
        if (!AUTHOR_REGEX.matcher(author).matches()) {
            throw new IllegalArgumentException("Author is invalid!");
        }
    }

    protected void throwExceptionIfInvalidPrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price is invalid!");
        }
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName())
            .append("<")
            .append("title=").append(this.title)
            .append(",")
            .append("author=").append(this.author)
            .append(",")
            .append("price=").append(this.price)
            .append(">");
        return sb.toString();
    }
}