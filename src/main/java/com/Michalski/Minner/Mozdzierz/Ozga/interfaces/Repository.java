package com.Michalski.Minner.Mozdzierz.Ozga.interfaces;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Repository<T> {
    void save(T element);
    void update(T element);
    void remove(T element);
    void removeById(Long id);

    List<T> getByPredictor(Predicate<? super T> predicate);

    Optional<T> getById(Long id);
}
