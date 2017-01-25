package com.chmykhun.jdbc.dao;

import java.io.Serializable;
import java.util.List;

public interface AbstractDao<K extends Serializable, T> {

    K save(T entity);

    void update(T entity);

    void delete(T entity);

    T findById(K id);

    List<T> findAll();

}
