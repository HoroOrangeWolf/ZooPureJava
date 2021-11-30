package com.Michalski.Minner.Mozdzierz.Ozga.Tickets;

import com.Michalski.Minner.Mozdzierz.Ozga.Request.Request;
import com.Michalski.Minner.Mozdzierz.Ozga.interfaces.Repository;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

@NoArgsConstructor
public class TicketHistoryRepository implements Repository<TicketHistory> {

    private static final List<TicketHistory> repo = new ArrayList<>();
    private static long lastId = 1;

    private static long getNextId(){
        return ++lastId;
    }

    public static long getLastId() {
        return lastId;
    }

    @Override
    public void save(TicketHistory element) {
        element.setId(getNextId());

        repo.add(element);
    }

    @Override
    public void update(TicketHistory element) {
        Optional<TicketHistory> first = repo.stream().filter(f -> Objects.equals(f.getId(), element.getId())).findFirst();

        if(first.isEmpty())
            return;

        TicketHistory ticketHistory = first.get();

        ticketHistory.setTicketId(element.getTicketId());
        ticketHistory.setDate(element.getDate());
        ticketHistory.setUserID(element.getUserID());
        ticketHistory.setPrice(element.getPrice());
    }

    @Override
    public void remove(TicketHistory element) {
        repo.removeIf(f -> Objects.equals(f.getId(), element.getId()));
    }

    @Override
    public void removeById(Long id) {
        repo.removeIf(f -> Objects.equals(f.getId(), id));
    }

    @Override
    public List<TicketHistory> getByPredictor(Predicate<? super TicketHistory> predicate) {
        return repo.stream().filter(predicate).toList();
    }

    @Override
    public Optional<TicketHistory> getById(Long id) {
        return repo.stream().filter(f -> Objects.equals(f.getId(), id)).findFirst();
    }
}
