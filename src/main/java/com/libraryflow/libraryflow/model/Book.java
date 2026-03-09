package com.libraryflow.libraryflow.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String title;

    @Column(nullable = false, unique = true)
    @NotNull
    private String isbn;
    private Author author;
    private Integer publicationYear;
    
    public Book(Long id, @NotNull String title, @NotNull String isbn, Author author, Integer publicationYear) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.publicationYear = publicationYear;
    }
 

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getIsbn() {
        return isbn;
    }
    public Author getAuthor() {
        return author;
    }
    public Integer getPublicationYear() {
        return publicationYear;
    }
}
