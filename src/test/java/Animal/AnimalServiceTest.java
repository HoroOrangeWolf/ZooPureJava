package Animal;

import com.Michalski.Minner.Mozdzierz.Ozga.Animal.Animal;
import com.Michalski.Minner.Mozdzierz.Ozga.Animal.AnimalService;
import com.Michalski.Minner.Mozdzierz.Ozga.Animal.Section;
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

        Section section = new Section(1L, "name", "description", true, 1.0f, 10.f, "t");

        service.addSection(section);

        Optional<Section> section1 = service.getSection(section.getId());

        Assertions.assertTrue(section1.isPresent());

        Section fromService = section1.get();

        Assertions.assertEquals(section, fromService);
    }

    @Test
    public void removeSection(){
        Section section = new Section(1L, "name", "description", true, 1.0f, 10.f, "t");

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

        Section section1 = new Section(1L, "Sekcja1", "Sekcja2", true, 1.f, 2.f, "");
        Section section2 = new Section(1L, "Sekcja2", "Sekcja3", true, 1.f, 2.f, "url");

        service.addSection(section1);
        service.addSection(section2);

        List<Section> list = service.getAllSections();

        Assertions.assertArrayEquals(new Section[]{section1, section2}, list.toArray(new Section[0]));
    }

}
