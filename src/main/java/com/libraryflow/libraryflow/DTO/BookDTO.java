package com.libraryflow.libraryflow.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDTO {

    private Long id;
    private String title;
    private String isbn;
    private Long authorId;
    private Integer publicationYear;

    public BookDTO(String title, String isbn, Long authorId, Integer publicationYear) {
        this.title = title;
        this.isbn = isbn;
        this.authorId = authorId;
        this.publicationYear = publicationYear;
    }
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
