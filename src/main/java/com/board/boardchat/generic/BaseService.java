package com.board.boardchat.generic;

import org.hibernate.service.spi.ServiceException;

import java.io.Serializable;
import java.util.List;

public interface BaseService<K extends Serializable & Comparable<K>, E> {
    void save(E entity) throws ServiceException, ServiceException;
    void update(E entity) throws ServiceException;
    void create(E entity) throws ServiceException;
    void delete(E entity) throws ServiceException;

    void save(Iterable<E> entities) throws ServiceException;
    void delete(Iterable<E> entities) throws ServiceException;

    E getById(K id);
    List<E> list();
    Long count();
    void flush();
}
