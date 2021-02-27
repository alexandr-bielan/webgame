package com.web.server.webserver.dao;

public interface CrudDAO<T> {

    void save(T t);

    void update(T t) ;

    void deleteById(int id);

    T findById(int id);
}
