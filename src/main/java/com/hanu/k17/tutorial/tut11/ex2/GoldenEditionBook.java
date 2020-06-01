package com.hanu.k17.tutorial.tut11.ex2;

public class GoldenEditionBook extends Book {

    public GoldenEditionBook(String title, String author, double price) {
        super(title, author, price);
        super.setPrice(price * 130 / 100);
    }
    
}