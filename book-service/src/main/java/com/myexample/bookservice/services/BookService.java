package com.myexample.bookservice.services;

import com.myexample.bookservice.dtos.BookDTO;
import com.myexample.bookservice.models.Book;
import com.myexample.bookservice.repository.BookRepository;
import com.myexample.bookservice.services.converters.BookConverter;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookConverter bookConverter;

    public BookService(BookRepository bookRepository, BookConverter bookConverter) {
        this.bookRepository = bookRepository;
        this.bookConverter = bookConverter;
    }

    public Mono<BookDTO> findByName(String name){
        return bookRepository.findByName(name).map(bookConverter::from);
    }

    public Mono<BookDTO> insert(BookDTO bookDTO) {
        Book book = bookConverter.from(bookDTO);
        return bookRepository.save(book).map(bookConverter::from);
    }
}
