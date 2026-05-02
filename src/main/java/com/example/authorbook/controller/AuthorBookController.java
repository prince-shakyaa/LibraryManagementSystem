package com.example.authorbook.controller;

import com.example.authorbook.model.Author;
import com.example.authorbook.model.Book;
import com.example.authorbook.service.AuthorService;
import com.example.authorbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthorBookController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listBooks", bookService.getAllBooksWithAuthors());
        model.addAttribute("listAuthors", authorService.getAllAuthors());
        return "index";
    }

    // --- AUTHOR MAPPINGS ---

    @GetMapping("/showNewAuthorForm")
    public String showNewAuthorForm(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "new_author";
    }

    @PostMapping("/saveAuthor")
    public String saveAuthor(@ModelAttribute("author") Author author, RedirectAttributes redirectAttributes) {
        try {
            authorService.saveAuthor(author);
            redirectAttributes.addFlashAttribute("message", "Author saved successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/showNewAuthorForm";
        }
        return "redirect:/";
    }

    @GetMapping("/showFormForAuthorUpdate/{id}")
    public String showFormForAuthorUpdate(@PathVariable(value = "id") Long id, Model model) {
        Author author = authorService.getAuthorById(id);
        model.addAttribute("author", author);
        return "update_author";
    }

    // --- BOOK MAPPINGS ---

    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.getAllAuthors());
        return "new_book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        try {
            bookService.saveBook(book);
            redirectAttributes.addFlashAttribute("message", "Book saved successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/showNewBookForm";
        }
        return "redirect:/";
    }

    @GetMapping("/showFormForBookUpdate/{id}")
    public String showFormForBookUpdate(@PathVariable(value = "id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.getAllAuthors());
        return "update_book";
    }
}
