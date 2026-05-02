package com.example.authorbook.repository;

import com.example.authorbook.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Custom query performing an INNER JOIN between Book and Author
    @Query("SELECT b FROM Book b JOIN FETCH b.author")
    List<Book> findAllWithAuthor();
}
