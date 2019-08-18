package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

public class Book {
    private final String suthor;
    private final String title;
    private final int yearOfPublication;

    public Book(final String suthor, final String title, final int yearOfPublication) {
        this.suthor = suthor;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
    }

    public String getSuthor() {
        return suthor;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
}
