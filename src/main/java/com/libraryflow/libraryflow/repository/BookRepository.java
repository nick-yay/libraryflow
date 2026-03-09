package com.libraryflow.libraryflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.libraryflow.libraryflow.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
