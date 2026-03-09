package com.libraryflow.libraryflow.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.libraryflow.libraryflow.DTO.BookDTO;
import com.libraryflow.libraryflow.model.Author;
import com.libraryflow.libraryflow.model.Book;
import com.libraryflow.libraryflow.repository.AuthorRepository;
import com.libraryflow.libraryflow.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository repo;

    @Autowired
    private AuthorRepository authorRepo;

    public BookDTO criar(BookDTO dto) {
        Author author = authorRepo.findById(dto.getAuthorId())
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, 
                "Autor não encontrado ID: " + dto.getAuthorId()
            ));
        
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setIsbn(dto.getIsbn());
        book.setAuthor(author);
        book.setPublicationYear(dto.getPublicationYear());
        book = repo.save(book);
        return toDto(book);
    }

     public List<BookDTO> findAll() {
        List<Book> books = repo.findAll();
        return books.stream()
            .map(this::toDto) 
            .collect(Collectors.toList());
    }

    public BookDTO getBook(Long id) {
        Book book = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        return toDto(book);
    }
    public BookDTO update(Long id, BookDTO dto) {
        Book book = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        Author author = authorRepo.findById(dto.getAuthorId())
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Autor não encontrado ID: " + dto.getAuthorId()
                ));
                
        book.setTitle(dto.getTitle());
        book.setPublicationYear(dto.getPublicationYear());
        book.setAuthor(author);
        book = repo.save(book);
        return toDto(book);
    }
    public void delete(Long id) {
        Book book = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        repo.delete(book);
    }
    private BookDTO toDto(Book book) {
    BookDTO dto = new BookDTO();
    dto.setId(book.getId());
    dto.setTitle(book.getTitle());
    dto.setIsbn(book.getIsbn());
    dto.setPublicationYear(book.getPublicationYear());
    
    if (book.getAuthor() != null) {
        dto.setAuthorId(book.getAuthor().getId());
    }
    return dto;
}
}
