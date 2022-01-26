package com.Michalski.Minner.Mozdzierz.Ozga.Notification;

import com.Michalski.Minner.Mozdzierz.Ozga.interfaces.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class NotificationRepository implements Repository<Notification> {

    private static long lastId = 1;
    private static final List<Notification> repo = new ArrayList<>();

    private static long getNextId(){
        return ++lastId;
    }

    public static long getLastId() {
        return lastId;
    }

    @Override
    public void save(Notification element) {
        element.setId(getNextId());
        repo.add(element);
    }

    @Override
    public void update(Notification element) {
        Optional<Notification> first = repo.stream().filter(f -> Objects.equals(f.getId(), element.getId())).findFirst();

        if(first.isEmpty())
            return;

        Notification notification = first.get();

        notification.setText(element.getText());
        notification.setType(element.getType());
        notification.setRead(element.isRead());
    }

    @Override
    public void remove(Notification element) {
        repo.removeIf(f -> Objects.equals(f.getId(), element.getId()));
    }

    @Override
    public void removeById(Long id) {
        repo.removeIf(f -> Objects.equals(f.getId(), id));
    }

    @Override
    public List<Notification> getByPredictor(Predicate<? super Notification> predicate) {
        return repo.stream().filter(predicate).toList();
    }

    @Override
    public Optional<Notification> getById(Long id) {
        return repo.stream().filter(f -> Objects.equals(f.getId(), id)).findFirst();
    }
}
