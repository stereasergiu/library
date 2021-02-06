package com.myexample.bookservice.api;

import com.myexample.bookservice.dtos.BookDTO;
import reactor.core.publisher.Mono;

public interface BookApi {

    Mono<BookDTO> findByName(String name);

    Mono<BookDTO> save(BookDTO bookDTO);

}
