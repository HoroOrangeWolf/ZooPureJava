package Animal;

import com.Michalski.Minner.Mozdzierz.Ozga.Animal.Animal;
import com.Michalski.Minner.Mozdzierz.Ozga.Animal.AnimalRepository;
import com.Michalski.Minner.Mozdzierz.Ozga.Animal.Section;
import com.Michalski.Minner.Mozdzierz.Ozga.Animal.SectionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class SectionRepositoryTest {
    private final SectionRepository repository = new SectionRepository();

    @AfterEach
    public void remove(){
        repository.getByPredictor(f -> true).forEach(f -> repository.removeById(f.getId()));
        System.out.println("Wyczyszczono...");
    }


    @Test
    public void addSection(){
        Section section = new Section(1L, "Sekcja1", "Opis", true, 0.f, 5.f, "url");

        repository.save(section);

        Assertions.assertTrue(repository.getById(section.getId()).isPresent());
    }

    @Test
    public void updateSection(){
        Section section = new Section(1L, "Sekcja1", "Opis", true, 0.f, 5.f, "url");

        repository.save(section);

        Section section1 = new Section(section.getId(), "Sekcja1", "Do aktualizacji", true, 12.5f, 4.f, "Nowy link");

        repository.update(section1);

        Assertions.assertEquals(section, section1);
    }

    @Test
    public void removeAnimal(){
        Section section = new Section(1L, "Sekcja1", "Opis", true, 0.f, 5.f, "url");

        repository.save(section);

        repository.remove(section);

        Assertions.assertTrue(repository.getById(section.getId()).isEmpty());
    }

    @Test
    public void removeAnimalById(){
        Section section = new Section(1L, "Sekcja1", "Opis", true, 0.f, 5.f, "url");

        repository.save(section);

        repository.removeById(section.getId());

        Assertions.assertTrue(repository.getById(section.getId()).isEmpty());
    }

    @Test
    public void getAnimalById(){
        Section section = new Section(1L, "Sekcja1", "Opis", true, 0.f, 5.f, "url");

        repository.save(section);

        Optional<Section> sectionOptional = repository.getById(section.getId());

        Assertions.assertTrue(sectionOptional.isPresent());

        Assertions.assertEquals(section, sectionOptional.get());
    }
}
