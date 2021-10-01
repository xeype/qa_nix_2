package com.xeype.config;

public enum FileType {

    AUTHORS_JSON_TYPE("authors.json"),
    AUTHORS_CSV_TYPE("authors.csv"),
    BOOKS_JSON_TYPE("books.json"),
    BOOKS_CSV_TYPE("books.csv");

    private final String path;

    FileType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
