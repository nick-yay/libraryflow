package com.libraryflow.libraryflow.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nacionality;
    @Max(500)
    private String biography;
    private List<Book> books=new ArrayList<>();
    
    public Author(Long id, String name, String nacionality, String biography) {
        this.id = id;
        this.name = name;
        this.nacionality = nacionality;
        this.biography = biography;

    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getNacionality() {
        return nacionality;
    }
    public String getBiography() {
        return biography;
    }
    public List<Book> getBooks() {
        return books;
    }
}
