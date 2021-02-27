package com.web.server.webserver.service;

public interface CRUDService<T> {

    void save(T t);

    void deleteById(int id);

    void update(T t);

    T findById(int id);
}
