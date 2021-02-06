package com.myexample.bookservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "books")
public class Book {

    @Id
    private final String id;
    private final String name;
    private final List<String> authors;
    private final List<Review> reviews;

    public Book(String id, String name, List<String> authors, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.reviews = reviews;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
