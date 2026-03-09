package com.libraryflow.libraryflow.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String nationality;
    @Column(length = 500)
    private String biography;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, 
               fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Book> books=new ArrayList<>();
    
    public Author() {
    }
    public Author(Long id, String name, String nationality, String biography) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.biography = biography;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
