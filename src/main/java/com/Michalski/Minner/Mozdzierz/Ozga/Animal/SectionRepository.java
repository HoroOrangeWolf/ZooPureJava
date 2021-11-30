package com.Michalski.Minner.Mozdzierz.Ozga.Animal;

import com.Michalski.Minner.Mozdzierz.Ozga.interfaces.Repository;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.Predicate;

@NoArgsConstructor
public class SectionRepository implements Repository<Section> {

    private static long lastId = 1;
    private static final List<Section> repo = new ArrayList<>();

    private static long getNextId(){
        return ++lastId;
    }

    public static long getLastId() {
        return lastId;
    }

    @Override
    public void save(Section element) {
        element.setId(getNextId());
        repo.add(element);
    }

    @Override
    public void update(Section element) {
        Optional<Section> optionalSection = repo.stream().filter((f) -> Objects.equals(f.getId(), element.getId())).findFirst();

        if(optionalSection.isEmpty())
            return;

        Section section = optionalSection.get();

        section.setDescription(element.getDescription());
        section.setSectionUrlImage(element.getSectionUrlImage());
        section.setMapx(element.getMapx());
        section.setMapy(element.getMapy());
        section.setIsOnTheMap(element.getIsOnTheMap());
        section.setName(element.getName());
    }

    @Override
    public void remove(Section element) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public List<Section> getByPredictor(Predicate<? super Section> predicate) {
        return repo.stream().filter(predicate).toList();
    }

    @Override
    public Optional<Section> getById(Long id) {
        return Optional.empty();
    }
}
