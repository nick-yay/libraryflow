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

}
