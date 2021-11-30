package com.Michalski.Minner.Mozdzierz.Ozga.Request;

import com.Michalski.Minner.Mozdzierz.Ozga.Animal.Animal;
import com.Michalski.Minner.Mozdzierz.Ozga.Animal.Section;
import com.Michalski.Minner.Mozdzierz.Ozga.interfaces.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class RequestRepository implements Repository<Request> {

    private static final List<Request> repo = new ArrayList<>();
    private static long lastId = 1;

    private static long getNextId(){
        return ++lastId;
    }

    public static long getLastId() {
        return lastId;
    }

    @Override
    public void save(Request element){
        element.setId(getNextId());
        repo.add(element);
    }

    @Override
    public void update(Request element) {
        Optional<Request> requestOptional = repo.stream().filter(f -> Objects.equals(f.getId(), element.getId())).findFirst();

        if(requestOptional.isEmpty())
            return;

        Request request = requestOptional.get();

        request.setStatus(element.getStatus());
        request.setText(element.getText());
    }

    @Override
    public void remove(Request element) {
        repo.removeIf(f->Objects.equals(f.getId(), element.getId()));
    }

    @Override
    public void removeById(Long id) {
        repo.removeIf(f->Objects.equals(f.getId(), id));
    }

    @Override
    public List<Request> getByPredictor(Predicate<? super Request> predicate) {
        return repo.stream().filter(predicate).toList();
    }

    @Override
    public Optional<Request> getById(Long id) {
        return repo.stream().filter(f -> Objects.equals(f.getId(), id)).findFirst();
    }
}
