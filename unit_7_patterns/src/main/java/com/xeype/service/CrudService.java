package com.xeype.service;

import com.xeype.entity.BaseEntity;

import java.util.List;

public interface CrudService<E extends BaseEntity> {

    void create(E e);
    void update(E e);
    void delete(String id);
    E findById(String id);
    List<E> findAll();
}
