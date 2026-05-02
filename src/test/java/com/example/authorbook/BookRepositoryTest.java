package com.example.authorbook;

import com.example.authorbook.model.Author;
import com.example.authorbook.model.Book;
import com.example.authorbook.repository.AuthorRepository;
import com.example.authorbook.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testFindAllWithAuthor() {
        // Data is populated by data.sql, so we just need to verify the inner join
        List<Book> books = bookRepository.findAllWithAuthor();

        assertFalse(books.isEmpty(), "Books list should not be empty");
        
        // Assert that the author is fetched along with the book without LazyInitializationException
        Book firstBook = books.get(0);
        assertNotNull(firstBook.getAuthor(), "Author should be joined and fetched");
        assertNotNull(firstBook.getAuthor().getName(), "Author name should be accessible");
    }
}
