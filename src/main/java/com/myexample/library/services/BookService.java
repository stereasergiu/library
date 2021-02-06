package com.myexample.library.services;

import com.myexample.bookservice.api.BookApi;
import com.myexample.bookservice.dtos.BookDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;

@Service
public class BookService implements BookApi {

    private final WebClient webClient;

    public BookService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @Override
    public Mono<BookDTO> findByName(String name) {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8082/api/book/{bookName}").build(name);
        return webClient.get().uri(uri).retrieve().bodyToMono(BookDTO.class);
    }

    @Override
    public Mono<BookDTO> save(BookDTO bookDTO) {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8082/api/book").build().toUri();
        return webClient.post().uri(uri).body(Mono.just(bookDTO), BookDTO.class).retrieve().bodyToMono(BookDTO.class);
    }
}
