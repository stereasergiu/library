package com.myexample.bookservice.services.converters;

import com.myexample.bookservice.dtos.ReviewDTO;
import com.myexample.bookservice.models.Review;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ReviewConverter {

    public List<Review> fromDTOs(List<ReviewDTO> review) {
        return review.stream().map(this::from).collect(toList());
    }

    public Review from(ReviewDTO reviewDTO) {
        return new Review(reviewDTO.id,
                          reviewDTO.author,
                          reviewDTO.content);
    }
    public List<ReviewDTO> fromModels(List<Review> reviewDTOS) {
        return reviewDTOS.stream().map(this::from).collect(toList());
    }

    public ReviewDTO from(Review review) {
        return new com.myexample.bookservice.dtos.ReviewDTO(review.getId(),
                                                            review.getAuthor(),
                                                            review.getContent());
    }
}
