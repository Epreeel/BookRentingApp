package com.eldroid.bookborrowapp;

public class Book {
    private String code;
    private String title;
    private String author;
    private boolean isPremium;
    private boolean isBorrowed;
    private int numDaysBorrowed;

    public Book(String code, String title, String author, boolean isPremium, boolean isBorrowed, int numDaysBorrowed) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.isPremium = isPremium;
        this.isBorrowed = false;
        this.numDaysBorrowed = 0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public int getNumDaysBorrowed() {
        return numDaysBorrowed;
    }

    public void setNumDaysBorrowed(int numDaysBorrowed) {
        this.numDaysBorrowed = numDaysBorrowed;
    }
}
