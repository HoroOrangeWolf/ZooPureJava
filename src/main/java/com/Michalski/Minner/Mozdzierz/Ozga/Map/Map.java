package com.Michalski.Minner.Mozdzierz.Ozga.Map;

import com.Michalski.Minner.Mozdzierz.Ozga.Animal.Animal;

import java.util.ArrayList;
import java.util.List;

public abstract class Map {
    private String description;
    private final List<Animal> zone = new ArrayList<>();
    public abstract void createMapZone();

    public List<Animal> getAnimals() {
        return zone;
    }

    public void addAnimal(Animal animal){
        zone.add(animal);
    }

    void renderMap(){};
}
