package com.myexample.bookservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewDTO {

    public String id;
    public String author;
    public String content;

}
