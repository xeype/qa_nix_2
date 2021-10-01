package com.xeype.service;

import com.xeype.config.DaoFactory;
import com.xeype.dao.CrudDao;
import com.xeype.entity.Author;
import com.xeype.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements CrudService<Book>{

    private final CrudDao<Book> bookDao = DaoFactory.getInstance().getBookDao();
    private final CrudDao<Author> authorDao = DaoFactory.getInstance().getAuthorDao();

    @Override
    public void create(Book book) {
        bookDao.create(book);
        List<String> authorIds = book.getAuthorsId();
        for (String authorId : authorIds) {
            authorDao.link(authorId, book.getId());
        }
    }

    @Override
    public void update(Book book) {
        bookDao.update(book);
    }

    @Override
    public void delete(String id) {
        Book current = findById(id);
        List<String> authorIds = current.getAuthorsId();
        for (String authorId : authorIds) {
            authorDao.unlink(authorId, id);
        }
        bookDao.delete(id);
    }

    @Override
    public Book findById(String id) {
        return bookDao.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }
}
