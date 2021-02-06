package com.myexample.bookservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookDTO {

    public String id;
    public String name;
    public List<String> authors;
    public List<ReviewDTO> reviews;

}
