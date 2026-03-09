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

    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors = repo.findAll();
        return authors.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public AuthorDTO getAuthor(Long id) {
        Author author = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
        return toDto(author);
    }

    public AuthorDTO update(Long id, AuthorDTO dto) {
        Author author = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
        author.setName(dto.getName());
        author.setNationality(dto.getNationality());
        author.setBiography(dto.getBiography());
        author = repo.save(author);
        return toDto(author);
    }

    public void delete(Long id) {
        Author author = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
        repo.delete(author);
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
