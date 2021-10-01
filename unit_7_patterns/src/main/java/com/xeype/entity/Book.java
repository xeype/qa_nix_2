package com.xeype.entity;

import java.util.ArrayList;
import java.util.List;

public class Book extends BaseEntity {

    private String name;
    private String genre;
    private List<String> authorsId = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<String> getAuthorsId() {
        return authorsId;
    }

    public void setAuthorsId(List<String> authorsId) {
        this.authorsId = authorsId;
    }
}
