package com.xeype.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.xeype.config.FileType;
import com.xeype.entity.Author;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class JsonAuthorDao extends AbstractAuthorDao implements CrudDao<Author>, FileIO {

    @Override
    public void create(Author author) {
        loadEntity();
        createAuthor(author);
        storeEntity();
    }

    @Override
    public void update(Author author) {
        loadEntity();
        updateAuthor(author);
        storeEntity();
    }

    @Override
    public void delete(String id) {
        loadEntity();
        deleteAuthor(id);
        storeEntity();
    }

    @Override
    public Author findById(String id) {
        loadEntity();
        return findAuthorById(id);
    }

    @Override
    public List<Author> findAll() {
        loadEntity();
        return findAllAuthors();
    }

    @Override
    public boolean existBook(String authorId, String bookId) {
        loadEntity();
        return existBook(authorId,bookId);
    }

    @Override
    public void link(String authorId, String bookId) {
        loadEntity();
        linkBook(authorId, bookId);
        storeEntity();
    }

    @Override
    public void unlink(String authorId, String bookId) {
        loadEntity();
        unlinkBook(authorId, bookId);
        storeEntity();
    }

    @Override
    public void loadEntity() {
        super.authors.clear();
        try {
            String authorsOut = FileUtils.readFileToString(new File(FileType.AUTHORS_JSON_TYPE.getPath()), "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            super.authors = objectMapper.readValue(authorsOut, new TypeReference<>() { });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeEntity() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()))
                .registerTypeAdapter(Date.class, (JsonSerializer<Date>) (date, type, jsonSerializationContext) -> new JsonPrimitive(date.getTime()))
                .create();
        String authorsOut = gson.toJson(authors);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FileType.AUTHORS_JSON_TYPE.getPath()))) {
            writer.append(authorsOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
