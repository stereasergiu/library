package com.myexample.bookservice.controllers;

import com.myexample.bookservice.dtos.BookDTO;
import com.myexample.bookservice.services.BookService;
import com.myexample.bookservice.api.BookApi;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class BookController implements BookApi {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    @GetMapping("/api/book/{name}")
    public Mono<BookDTO> findByName(@PathVariable("name") String name) {
        return bookService.findByName(name);
    }

    @Override
    @PostMapping("/api/book")
    public Mono<BookDTO> save(@RequestBody BookDTO bookDTO) {
        return bookService.insert(bookDTO);
    }
}
