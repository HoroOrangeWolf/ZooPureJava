package com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone;

import com.Michalski.Minner.Mozdzierz.Ozga.Animal.Animal;

import java.util.ArrayList;
import java.util.List;

public class MonkeyInfoZone implements InfoZone{
    private List<Animal> animalList = new ArrayList<>();
    @Override
    public String description() {
        return null;
    }

    @Override
    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }
}
