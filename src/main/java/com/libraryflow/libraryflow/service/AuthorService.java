package com.libraryflow.libraryflow.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryflow.libraryflow.DTO.AuthorDTO;
import com.libraryflow.libraryflow.model.Author;
import com.libraryflow.libraryflow.repository.AuthorRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthorService {
    @Autowired
    private AuthorRepository repo;

    public AuthorDTO createAuthor(AuthorDTO dto) {
        Author author = new Author(null, dto.getName(), dto.getBiography(), dto.getNationality());
        author = repo.save(author);
        return toDto(author);
    }

    private AuthorDTO toDto(Author author) {
        AuthorDTO dto = new AuthorDTO(
            author.getName(),
            author.getNationality(),
            author.getBiography()
        );
        List<String> bookTitles = author.getBooks().stream()
                .map(book -> book.getTitle())
                .collect(Collectors.toList());
        
        dto.setBooks(bookTitles);
        return dto;
    }
}
