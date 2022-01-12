package com.Michalski.Minner.Mozdzierz.Ozga.Tickets;

import com.Michalski.Minner.Mozdzierz.Ozga.interfaces.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class PromotionRepository implements Repository<Promotion> {

    private static final List<Promotion> repo = new ArrayList<>();
    private static long lastId = 1;

    private static long getNextId(){
        return ++lastId;
    }

    public static long getLastId() {
        return lastId;
    }

    @Override
    public void save(@org.jetbrains.annotations.NotNull Promotion element) {
        element.setId(getNextId());
        repo.add(element);
    }

    @Override
    public void update(Promotion element) {
        Optional<Promotion> first = repo.stream().filter(f -> Objects.equals(f.getId(), element.getId())).findFirst();

        if(first.isEmpty())
            return;

        Promotion promotion = first.get();

        promotion.setPrice(element.getPrice());
        promotion.setSections(element.getSections());
    }

    @Override
    public void remove(Promotion element) {
        repo.removeIf(f -> Objects.equals(f.getId(), element.getId()));
    }

    @Override
    public void removeById(Long id) {
        repo.removeIf(f -> Objects.equals(f.getId(), id));
    }

    @Override
    public List<Promotion> getByPredictor(Predicate<? super Promotion> predicate) {
        return repo.stream().filter(predicate).toList();
    }

    @Override
    public Optional<Promotion> getById(Long id) {
        return repo.stream().filter(f -> Objects.equals(f.getId(), id)).findFirst();
    }
}
