package com.example.authorbook.service;

import com.example.authorbook.model.Book;
import com.example.authorbook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooksWithAuthors() {
        return bookRepository.findAllWithAuthor();
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            throw new RuntimeException("Book not found for id :: " + id);
        }
    }

    public void saveBook(Book book) {
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            throw new RuntimeException("Error saving book. Possibly due to duplicate ISBN or missing Author.", e);
        }
    }
}
