package ru.narbekov.testproject.domain;

import java.util.Optional;

public interface CrudRepository<T> {
    Optional<T> findById(String id);
    T save(T entity);
    void deleteById(String guid);
}
