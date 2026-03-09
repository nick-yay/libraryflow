package com.libraryflow.libraryflow.DTO;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorDTO {

    private Long id;
    private String name;
    private String nationality;
    private String biography;
    private List<String> books;

    public AuthorDTO(String name, String nationality, String biography) {
        this.name = name;
        this.nationality = nationality;
        this.biography = biography;
    }
    public void setBooks(List<String> books) {
        this.books = books;
    }
}
