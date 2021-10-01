package com.xeype.dao;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.xeype.config.FileType;
import com.xeype.entity.Book;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvBookDao extends AbstractBookDao implements CrudDao<Book>, FileIO {

    private final List<String[]> csvData = new ArrayList<>();

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
        try (CSVReader reader = new CSVReader(new FileReader(FileType.BOOKS_CSV_TYPE.getPath()))) {
            super.books.clear();
            List<String[]> res = reader.readAll();

            for (int i = 1; i < res.size(); i++) {
                Book book = new Book();
                book.setId(res.get(i)[0]);
                book.setName(res.get(i)[1]);
                book.setGenre(res.get(i)[2]);
                List<String> authorIds = new ArrayList<>(Arrays.asList(res.get(i)[3]
                        .replace("[", "")
                        .replace("]", "")
                        .replace(" ", "")
                        .split(",")));
                book.setAuthorsId(authorIds);
                super.books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeEntity() {
        this.csvData.clear();
        writeHeader();
        for (Book book : super.books) {
            String[] currentBook = new String[4];
            currentBook[0] = book.getId();
            currentBook[1] = book.getName();
            currentBook[2] = book.getGenre();
            currentBook[3] = String.valueOf(book.getAuthorsId());
            csvData.add(currentBook);
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter(FileType.BOOKS_CSV_TYPE.getPath()))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeHeader() {
        String[] header = {"id", "name", "genre", "authorIds"};
        csvData.add(header);
    }
}
