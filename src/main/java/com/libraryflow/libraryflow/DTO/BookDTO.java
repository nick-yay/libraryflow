package com.libraryflow.libraryflow.DTO;

import lombok.Getter;

@Getter
public class BookDTO {

    private Long id;
    private String title;
    private String isbn;
    private String authorName;
    private Integer publicationYear;

    public BookDTO(String title, String isbn, String authorName, Integer publicationYear) {
        this.title = title;
        this.isbn = isbn;
        this.authorName = authorName;
        this.publicationYear = publicationYear;
    }
}
