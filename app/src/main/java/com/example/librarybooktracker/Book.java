package com.example.librarybooktracker;

public class Book {
    private String code;
    private String title;
    private String author;
    private String type;
    private boolean isBorrowed;
    private int numDaysBorrowed;

    public Book() {
    }

    public Book(String code, String title, String author, String type, boolean isBorrowed, int numDaysBorrowed) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
