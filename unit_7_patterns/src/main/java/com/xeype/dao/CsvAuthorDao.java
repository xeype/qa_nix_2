package com.xeype.dao;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;
import com.xeype.config.FileType;
import com.xeype.entity.Author;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service("CsvUserDao")
public class CsvAuthorDao extends AbstractAuthorDao implements CrudDao<Author>, FileIO {

    private final List<String[]> csvData = new ArrayList<>();

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
    public List findAll() {
        loadEntity();
        return findAllAuthors();
    }

    @Override
    public boolean existBook(String authorId, String bookId) {
        loadEntity();
        return existBook(authorId, bookId);
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
        try (CSVReader reader = new CSVReader(new FileReader(FileType.AUTHORS_CSV_TYPE.getPath()))) {
            super.authors.clear();
            List<String[]> res = reader.readAll();
            for (String[] re : res) {
                try {
                    Author author = new Author();
                    author.setId(re[0]);
                    author.setFirstName(re[1]);
                    author.setLastName(re[2]);
                    author.setBirthDay(new Date(Long.parseLong(re[3])));
                    author.setVisible(Boolean.parseBoolean(re[4]));
                    List<String> bookIds = new ArrayList<>(Arrays.asList(re[5]
                            .replace("[", "")
                            .replace("]", "")
                            .replace(" ", "")
                            .split(",")));
                    author.setBookIds(bookIds);
                    super.authors.add(author);
                } catch (Exception e) {
                    System.out.println("e = " + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeEntity() {
        this.csvData.clear();
        writeHeader();
        for (Author author : super.authors) {
            String[] currentAuthor = new String[6];
            currentAuthor[0] = author.getId();
            currentAuthor[1] = author.getFirstName();
            currentAuthor[2] = author.getLastName();
            currentAuthor[3] = String.valueOf(author.getBirthDay().getTime());
            currentAuthor[4] = String.valueOf(author.isVisible());
            currentAuthor[5] = String.valueOf(author.getBookIds());
            csvData.add(currentAuthor);
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter(FileType.AUTHORS_CSV_TYPE.getPath()))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeHeader() {
        String[] header = {"id", "firstName", "lastName", "birthDay", "isVisible", "bookIds"};
        csvData.add(header);
    }
}
