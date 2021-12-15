package com.Michalski.Minner.Mozdzierz.Ozga.User;

import com.Michalski.Minner.Mozdzierz.Ozga.interfaces.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class UserRepository implements Repository<User> {

    private static final List<User> repo = new ArrayList<>();
    private static long lastId = 1;

    private static long getNextId(){
        return ++lastId;
    }

    public static long getLastId() {
        return lastId;
    }

    @Override
    public void save(User element) {
        element.setId(element.getId());
        repo.add(element);
    }

    @Override
    public void update(User element) {
        Optional<User> first = repo.stream().filter((f) -> Objects.equals(f.getId(), element.getId())).findFirst();

        if(first.isEmpty())
            return;

        User user = first.get();

        user.setEmail(element.getEmail());
        user.setBokManager(element.isBokManager());
        user.setLastLogin(element.getLastLogin());
        user.setPassword(element.getPassword());

    }

    @Override
    public void remove(User element) {
        repo.removeIf(f -> Objects.equals(f.getId(), element.getId()));
    }

    @Override
    public void removeById(Long id) {
        repo.removeIf(f -> Objects.equals(f.getId(), id));
    }

    @Override
    public List<User> getByPredictor(Predicate<? super User> predicate) {
        return repo.stream().filter(predicate).toList();
    }

    @Override
    public Optional<User> getById(Long id) {
        return repo.stream().filter(f -> Objects.equals(f.getId(), id)).findFirst();
    }

    public Optional<User> getUserByEmail(String email){
        return repo.stream().filter(f -> f.getEmail().equals(email)).findFirst();
    }

    public boolean isEmailTaken(String email){
        return repo.stream().anyMatch(f -> f.getEmail().equals(email));
    }

    public boolean isBokUser(Long id){
        Optional<User> user = repo.stream().filter(f -> Objects.equals(f.getId(), id)).findFirst();

        if(user.isEmpty())
            return false;
        return user.get().isBokManager();
    }




}
