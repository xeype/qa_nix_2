package com.xeype.dto;

import com.xeype.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookResponseDto {

    private String id;
    private String name;
    private String genre;
    private List<String> authorIds = new ArrayList<>();

    public BookResponseDto(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.genre = book.getGenre();
        this.authorIds = book.getAuthorsId();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public List<String> getAuthorsId() {
        return authorIds;
    }
}
