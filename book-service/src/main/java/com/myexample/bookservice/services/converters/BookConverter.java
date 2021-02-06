package com.myexample.bookservice.services.converters;

import com.myexample.bookservice.dtos.BookDTO;
import com.myexample.bookservice.models.Book;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {

    private final ReviewConverter reviewConverter;

    public BookConverter(ReviewConverter reviewConverter) {
        this.reviewConverter = reviewConverter;
    }

    public BookDTO from(Book book) {
        return new com.myexample.bookservice.dtos.BookDTO(book.getId(),
                                                          book.getName(),
                                                          book.getAuthors(),
                                                          reviewConverter.fromModels(book.getReviews()));
    }

    public Book from(BookDTO bookDTO) {
        return new Book(bookDTO.id,
                        bookDTO.name,
                        bookDTO.authors,
                        reviewConverter.fromDTOs(bookDTO.reviews));
    }
}
