package com.Michalski.Minner.Mozdzierz.Ozga.Animal;

import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.Section;

import java.util.List;
import java.util.Optional;

public class AnimalService {

    private final AnimalRepository animalRepository = new AnimalRepository();
    private final SectionRepository sectionRepository = new SectionRepository();

    public void addSection(Section section){
        sectionRepository.save(section);
    }

    public void removeSectionById(Long id){
        sectionRepository.removeById(id);
    }

    public void addAnimal(Animal animal){
        animalRepository.save(animal);
    }

    public void removeAnimal(Long id){
        animalRepository.removeById(id);
    }

    public void updateSection(Section section){
        sectionRepository.update(section);
    }

    public void updateAnimal(Animal animal){
        animalRepository.update(animal);
    }

    public Optional<Animal> getAnimal(Long id){
        return animalRepository.getById(id);
    }

    public Optional<Section> getSection(Long id){
        return sectionRepository.getById(id);
    }

    public List<Section> getAllSections(){
        return sectionRepository.getByPredictor(f->true);
    }

    public List<Animal> getAllAnimals(){
        return animalRepository.getByPredictor(f->true);
    }

    public List<Section> getSectionsOnMap(){
        return sectionRepository.getByPredictor(Section::isOnTheMap);
    }




}
