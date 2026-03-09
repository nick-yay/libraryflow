package com.libraryflow.libraryflow.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.libraryflow.libraryflow.DTO.BookDTO;
import com.libraryflow.libraryflow.service.BookService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {
    
    @Autowired 
    private BookService service;
    
    
    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll() {
        List<BookDTO> books = service.findAll();
        return ResponseEntity.ok(books);
    }
    
    @PostMapping        
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO dto) {
        BookDTO createdBook = service.criar(dto);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}") 
    public ResponseEntity<BookDTO> getBook(@PathVariable Long id) {
        BookDTO book = service.getBook(id);
        return ResponseEntity.ok(book);
    }
    
    @PutMapping("/{id}") 
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO dto) {
        BookDTO updatedBook = service.update(id, dto);
        return ResponseEntity.ok(updatedBook);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}