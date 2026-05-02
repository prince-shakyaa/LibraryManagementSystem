package com.example.authorbook;

import com.example.authorbook.model.Author;
import com.example.authorbook.repository.AuthorRepository;
import com.example.authorbook.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    @Test
    public void testGetAuthorById_Found() {
        Author author = new Author("Test Author", "test@test.com");
        author.setId(1L);

        when(authorRepository.findById(1L)).thenReturn(Optional.of(author));

        Author result = authorService.getAuthorById(1L);

        assertNotNull(result);
        assertEquals("Test Author", result.getName());
        verify(authorRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetAuthorById_NotFound() {
        when(authorRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            authorService.getAuthorById(1L);
        });

        verify(authorRepository, times(1)).findById(1L);
    }
}
