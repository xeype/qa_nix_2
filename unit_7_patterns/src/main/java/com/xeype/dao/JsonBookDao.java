package com.xeype.dao;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.xeype.config.FileType;
import com.xeype.entity.Book;
import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class JsonBookDao extends AbstractBookDao implements CrudDao<Book>, FileIO {

        @Override
        public void create(Book book) {
            loadEntity();
            createBook(book);
            storeEntity();
        }

        @Override
        public void update(Book book) {
            loadEntity();
            updateBook(book);
            storeEntity();
        }

        @Override
        public void delete(String id) {
            loadEntity();
            deleteBook(id);
            storeEntity();
        }

        @Override
        public Book findById(String id) {
            loadEntity();
            return findBookById(id);
        }

        @Override
        public List<Book> findAll() {
            loadEntity();
            return findAllBooks();
        }

        @Override
        public void link(String authorId, String bookId) {
            loadEntity();
            linkAuthor(authorId, bookId);
            storeEntity();
        }

        @Override
        public void unlink(String authorId, String bookId) {
            loadEntity();
            unlinkAuthor(authorId, bookId);
            storeEntity();
        }

        @Override
        public void loadEntity() {
            super.books.clear();
            try {
                String booksOut = FileUtils.readFileToString(new File(FileType.BOOKS_JSON_TYPE.getPath()), "UTF-8");
                ObjectMapper objectMapper = new ObjectMapper();
                super.books = objectMapper.readValue(booksOut, new TypeReference<List<Book>>()  { });
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
            String bookOut = gson.toJson(books);
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(FileType.BOOKS_JSON_TYPE.getPath()))) {
                writer.append(bookOut);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
