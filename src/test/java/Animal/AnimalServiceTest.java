package Animal;

import com.Michalski.Minner.Mozdzierz.Ozga.Animal.Animal;
import com.Michalski.Minner.Mozdzierz.Ozga.Animal.AnimalService;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.Section;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.MapZone.AfricanariumSectionCreator;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.MapZone.SectionCreator;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;

public class AnimalServiceTest {

    private final AnimalService service = new AnimalService();

    @AfterEach
    public void remove(){
        service.getAllAnimals().forEach(f -> service.removeAnimal(f.getId()));
        service.getAllSections().forEach(f -> service.removeSectionById(f.getId()));
        System.out.println("Wyczyszczono...");
    }

    @Test
    public void AddSection(){
        SectionCreator sectionCreator = new AfricanariumSectionCreator();

        Section section = sectionCreator.createSection();

        section.setUp(1L, "desc", true, 1.f, 1.f);

        service.addSection(section);

        Optional<Section> section1 = service.getSection(section.getId());

        Assertions.assertTrue(section1.isPresent());

        Section fromService = section1.get();

        Assertions.assertEquals(section, fromService);
    }

    @Test
    public void removeSection(){
        SectionCreator sectionCreator = new AfricanariumSectionCreator();

        Section section = sectionCreator.createSection();

        section.setUp(1L, "desc", true, 1.f, 1.f);

        service.addSection(section);


        service.removeSectionById(section.getId());

        Assertions.assertTrue(service.getSection(section.getId()).isEmpty());
    }

    @Test
    public void addAnimal(){
        Animal animal = new Animal(1L, 1L, "Kot", "kot");

        service.addAnimal(animal);

        Optional<Animal> animal1 = service.getAnimal(animal.getId());

        Assertions.assertTrue(animal1.isPresent());

        Assertions.assertEquals(animal, animal1.get());
    }

    @Test
    public void removeAnimal(){
        Animal animal = new Animal(1L, 1L, "Pies", "Piesek");

        service.addAnimal(animal);

        Optional<Animal> animal1 = service.getAnimal(animal.getId());

        Assertions.assertTrue(animal1.isPresent());

        Assertions.assertEquals(animal, animal1.get());

        service.removeAnimal(animal.getId());

        Assertions.assertTrue(service.getAnimal(animal.getId()).isEmpty());
    }


    @Test
    public void getAllAnimals(){
        Animal animal1 = new Animal(1L, 1L, "Kot", "kot");
        Animal animal2 = new Animal(1L, 1L, "Pies", "Piesek");

        service.addAnimal(animal1);
        service.addAnimal(animal2);

        List<Animal> list = service.getAllAnimals();

        Assertions.assertArrayEquals(new Animal[]{animal1, animal2}, list.toArray(new Animal[0]));
    }

    @Test
    public void getAllSections(){

        SectionCreator sectionCreator = new AfricanariumSectionCreator();

        Section section = sectionCreator.createSection();

        section.setUp(1L, "desc", true, 1.f, 1.f);

        Section section2 = sectionCreator.createSection();

        section.setUp(1L, "descdsadasd", true, 1.f, 1.f);

        service.addSection(section);
        service.addSection(section2);

        List<Section> list = service.getAllSections();

        Assertions.assertArrayEquals(new Section[]{section, section2}, list.toArray(new Section[0]));
    }

}
