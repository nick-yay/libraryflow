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
}
