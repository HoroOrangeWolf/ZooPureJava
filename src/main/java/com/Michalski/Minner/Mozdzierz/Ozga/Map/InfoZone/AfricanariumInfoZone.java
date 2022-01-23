package com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone;

import com.Michalski.Minner.Mozdzierz.Ozga.Animal.Animal;

import java.util.ArrayList;
import java.util.List;

public class AfricanariumInfoZone implements InfoZone{
    private final List<Animal> animalList = new ArrayList<>();
    @Override
    public String description() {
        return null;
    }

    @Override
    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }
}
