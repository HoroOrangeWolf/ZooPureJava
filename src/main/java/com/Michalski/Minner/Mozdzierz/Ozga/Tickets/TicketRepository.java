package com.Michalski.Minner.Mozdzierz.Ozga.Tickets;

import com.Michalski.Minner.Mozdzierz.Ozga.Request.Request;
import com.Michalski.Minner.Mozdzierz.Ozga.interfaces.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class TicketRepository implements Repository<Ticket> {

    private static final List<Ticket> repo = new ArrayList<>();
    private static long lastId = 1;

    private static long getNextId(){
        return ++lastId;
    }

    public static long getLastId() {
        return lastId;
    }

    @Override
    public void save(@org.jetbrains.annotations.NotNull Ticket element) {
        element.setId(getNextId());
        repo.add(element);
    }

    @Override
    public void update(Ticket element) {
        Optional<Ticket> first = repo.stream().filter(f -> Objects.equals(f.getId(), element.getId())).findFirst();

        if(first.isEmpty())
            return;

        Ticket ticket = first.get();

        ticket.setName(element.getName());
        ticket.setDescription(element.getDescription());
        ticket.setPrice(element.getPrice());
    }

    @Override
    public void remove(Ticket element) {
        repo.removeIf(f -> Objects.equals(f.getId(), element.getId()));
    }

    @Override
    public void removeById(Long id) {
        repo.removeIf(f -> Objects.equals(f.getId(), id));
    }

    @Override
    public List<Ticket> getByPredictor(Predicate<? super Ticket> predicate) {
        return repo.stream().filter(predicate).toList();
    }

    @Override
    public Optional<Ticket> getById(Long id) {
        return repo.stream().filter(f -> Objects.equals(f.getId(), id)).findFirst();
    }
}
