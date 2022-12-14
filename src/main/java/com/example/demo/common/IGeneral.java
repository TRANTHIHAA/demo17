package com.example.demo.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGeneral<E> {
    Page<E> findAll(Pageable pageable);

    Optional<E> findById(Long id);

    E save(E t);

    void removeById(Long id);
}
