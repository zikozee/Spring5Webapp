package com.zikozee.spring5webapp.controller;

import com.zikozee.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    private BookRepository bookRepository;// use service rather than repo directly

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());

        return "books";
    }
}
