package com.Michalski.Minner.Mozdzierz.Ozga.Animal;

import com.Michalski.Minner.Mozdzierz.Ozga.interfaces.Repository;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.Predicate;

@NoArgsConstructor
public class AnimalRepository implements Repository<Animal> {
    private static long lastId = 1;
    private static final List<Animal> repo = new ArrayList<Animal>();

    private static long getNextId(){
        return ++lastId;
    }

    public static long getLastId() {
        return lastId;
    }

    @Override
    public void save(Animal animal){
        animal.setId(getNextId());
        repo.add(animal);
    }

    @Override
    public void update(Animal animal){
        Optional<Animal> optionalAnimal = repo.stream().filter((f)-> Objects.equals(f.getId(), animal.getId())).findFirst();

        if(optionalAnimal.isEmpty())
            return;

        Animal an = optionalAnimal.get();

        an.setName(animal.getName());
        an.setDescription(animal.getDescription());
        an.setIdSection(animal.getIdSection());

    }

    @Override
    public void remove(Animal element) {
        repo.removeIf((f)->Objects.equals(f.getId(), element.getId()));
    }

    @Override
    public void removeById(Long id) {
        repo.removeIf((f)->Objects.equals(f.getId(), id));
    }

    @Override
    public List<Animal> getByPredictor(Predicate<? super Animal> predicate) {
        return repo.stream().filter(predicate).toList();
    }

    @Override
    public Optional<Animal> getById(Long id) {
        return repo.stream().filter((f)-> Objects.equals(f.getId(), id)).findFirst();
    }

}
