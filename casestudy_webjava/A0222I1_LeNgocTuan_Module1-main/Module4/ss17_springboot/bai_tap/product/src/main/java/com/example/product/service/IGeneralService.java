package com.example.product.service;

import java.util.Optional;

public interface IGeneralService<E> {

    Iterable<E> findAll();

    Optional<E> findById(Integer id);

    void save(E t);

    void remove(Integer id);
}
