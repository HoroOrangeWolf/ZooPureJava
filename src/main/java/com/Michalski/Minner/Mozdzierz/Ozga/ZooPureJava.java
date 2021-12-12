package com.Michalski.Minner.Mozdzierz.Ozga;

import com.Michalski.Minner.Mozdzierz.Ozga.Animal.Animal;
import com.Michalski.Minner.Mozdzierz.Ozga.Animal.AnimalService;
import com.Michalski.Minner.Mozdzierz.Ozga.Animal.Section;

public class ZooPureJava {

    public static void main(String[] args) {

        AnimalService service = new AnimalService();

        Section section = new Section(1L, "Safari", "", false, 0.0f, 5.0f, ""),
                section2 = new Section(2L, "Rybki", "", true, 0.0f, 5.0f, "");

        service.addSection(section);
        service.addSection(section2);

        Animal animal = new Animal(1L,
                section.getId(),
                "Zyrafa",
                ""
                ),
                animal2 = new Animal(1L,
                        section.getId(),
                        "Lew",
                        ""
                ),
                animal3 = new Animal(1L,
                        section2.getId(),
                        "Rybka1",
                        ""),
                animal4 = new Animal(1L,
                        section2.getId(),
                        "Rybka2",
                        "");

        service.addAnimal(animal);
        service.addAnimal(animal2);
        service.addAnimal(animal3);
        service.addAnimal(animal4);

        System.out.println(service.getAllSections());
        System.out.println(service.getSectionsOnMap());
        System.out.println(service.getAllAnimals());


    }
}
