package com.myexample.library.controllers;

import com.myexample.bookservice.api.BookApi;
import com.myexample.bookservice.dtos.BookDTO;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class LibraryController {

    private final BookApi bookApi;

    public LibraryController(BookApi bookApi) {
        this.bookApi = bookApi;
    }

    @GetMapping("/library/book/{name}")
    public Mono<BookDTO> get(@PathVariable("name") String name) {
        return bookApi.findByName(name);
    }

    @PostMapping("/library/book")
    public Mono<BookDTO> get(@RequestBody BookDTO bookDTO) {
        return bookApi.save(bookDTO);
    }
}
