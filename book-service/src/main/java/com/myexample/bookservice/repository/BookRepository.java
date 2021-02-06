package com.myexample.bookservice.repository;

import com.myexample.bookservice.models.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {

    Mono<Book> findByName(String name);

}
