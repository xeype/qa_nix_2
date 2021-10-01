package com.xeype.dao;

import com.xeype.entity.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public abstract class AbstractAuthorDao {

    protected List<Author> authors = new ArrayList<>();

    protected void createAuthor(Author author) {
        author.setId(generateId());
        author.setVisible(true);
        authors.add(author);
    }

    protected void updateAuthor(Author author) {
        if (existById(author.getId())) {
            Author current = findAuthorById(author.getId());
            current.setId(author.getId());
            current.setFirstName(author.getFirstName());
            current.setLastName(author.getLastName());
            current.setBirthDay(author.getBirthDay());
        }
    }

    protected boolean existBook(String authorId, String bookId) {
        Author current = authors.stream().filter(author -> author.getId().equals(authorId)).findFirst().get();
        return current.getBookIds().stream().anyMatch(id -> id.equals(bookId));
    }

    protected void linkBook(String authorId, String bookId) {
        Author current = authors.stream().filter(author -> author.getId().equals(authorId)).findFirst().get();
        List<String> bookIds = current.getBookIds();
        bookIds.add(bookId);
    }

    protected void unlinkBook(String authorId, String bookId) {
        Author current = authors.stream().filter(author -> author.getId().equals(authorId)).findFirst().get();
        List<String> bookIds = current.getBookIds();
        bookIds.removeIf(id -> id.equals(bookId));
    }

    protected void deleteAuthor(String id) {
        if(existById(id)) {
            Author current = findAuthorById(id);
            current.setVisible(false);
        }
    }

    protected Author findAuthorById(String id) {
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().get();
    }

    protected List<Author> findAllAuthors() {
        return authors.stream().filter(Author::isVisible).collect(Collectors.toList());
    }

    private static List<Author> visibleAuthors(List<Author> authors) {
        return authors.stream().filter(Author::isVisible).collect(Collectors.toList());
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (existById(id)) {
            return generateId();
        }
        return id;
    }

    private boolean existById(String id) {
        return authors.stream().anyMatch(author -> author.getId().equals(id));
    }
}
