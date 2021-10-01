package com.xeype.dao;

import com.xeype.entity.BaseEntity;

import java.util.List;

public interface CrudDao<E extends BaseEntity>  {

    void create(E e);
    void update(E e);
    void delete(String id);
    E findById(String id);
    List<E> findAll();
    void link(String authorId, String bookId);
    void unlink(String authorId, String bookId);
}
