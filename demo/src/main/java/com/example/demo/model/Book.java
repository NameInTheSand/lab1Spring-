package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Book {
    private final UUID id;
    private final String name;
    private final String author;
    private final int year;
    private final String publisher;
    private final int counter;

    public Book(UUID id, String name, String author, int year, String publisher, int counter) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.counter = counter;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getCounter() {
        return counter;
    }
}
