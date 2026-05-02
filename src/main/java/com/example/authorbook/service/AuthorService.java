package com.example.authorbook.service;

import com.example.authorbook.model.Author;
import com.example.authorbook.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()) {
            return optionalAuthor.get();
        } else {
            throw new RuntimeException("Author not found for id :: " + id);
        }
    }

    public void saveAuthor(Author author) {
        try {
            authorRepository.save(author);
        } catch (Exception e) {
            throw new RuntimeException("Error saving author. Possibly due to duplicate email.", e);
        }
    }
}
