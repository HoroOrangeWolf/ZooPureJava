package com.Michalski.Minner.Mozdzierz.Ozga.Tickets;

import com.Michalski.Minner.Mozdzierz.Ozga.interfaces.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class AdvertisementRepository implements Repository<Advertisement> {

    private static final List<Advertisement> repo = new ArrayList<>();
    private static long lastId = 1;

    private static long getNextId(){
        return ++lastId;
    }

    public static long getLastId() {
        return lastId;
    }

    @Override
    public void save(@org.jetbrains.annotations.NotNull Advertisement element) {
        element.setId(getNextId());
        repo.add(element);
    }

    @Override
    public void update(Advertisement element) {
        Optional<Advertisement> first = repo.stream().filter(f -> Objects.equals(f.getId(), element.getId())).findFirst();

        if(first.isEmpty())
            return;

        Advertisement advertisement = first.get();

        advertisement.setPrice(advertisement.getPrice());
        advertisement.setSections(advertisement.getSections());
    }

    @Override
    public void remove(Advertisement element) {
        repo.removeIf(f -> Objects.equals(f.getId(), element.getId()));
    }

    @Override
    public void removeById(Long id) {
        repo.removeIf(f -> Objects.equals(f.getId(), id));
    }

    @Override
    public List<Advertisement> getByPredictor(Predicate<? super Advertisement> predicate) {
        return repo.stream().filter(predicate).toList();
    }

    @Override
    public Optional<Advertisement> getById(Long id) {
        return repo.stream().filter(f -> Objects.equals(f.getId(), id)).findFirst();
    }
}
