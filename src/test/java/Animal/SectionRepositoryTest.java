package Animal;

import com.Michalski.Minner.Mozdzierz.Ozga.Animal.SectionRepository;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.Section;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.MapZone.AfricanariumSectionCreator;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.MapZone.SectionCreator;
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
        SectionCreator sectionCreator = new AfricanariumSectionCreator();

        Section section = sectionCreator.createSection();

        section.setUp(1L, "desc", true, 1.f, 1.f);

        repository.save(section);

        Assertions.assertTrue(repository.getById(section.getId()).isPresent());
    }

    @Test
    public void updateSection(){
        SectionCreator sectionCreator = new AfricanariumSectionCreator();

        Section section = sectionCreator.createSection();

        section.setUp(1L, "desc", true, 1.f, 1.f);

        repository.save(section);

        Section section2 = sectionCreator.createSection();

        section2.setUp(section.getId(), "desc_to_update", true, 2.f, 2.f);

        repository.update(section2);

        Assertions.assertEquals(section.generateDescription(), section2.generateDescription());
    }

    @Test
    public void removeAnimal(){
        SectionCreator sectionCreator = new AfricanariumSectionCreator();

        Section section = sectionCreator.createSection();

        section.setUp(1L, "desc", true, 1.f, 1.f);

        repository.save(section);

        repository.remove(section);

        Assertions.assertTrue(repository.getById(section.getId()).isEmpty());
    }

    @Test
    public void removeAnimalById(){
        SectionCreator sectionCreator = new AfricanariumSectionCreator();

        Section section = sectionCreator.createSection();

        section.setUp(1L, "desc", true, 1.f, 1.f);

        repository.save(section);

        repository.removeById(section.getId());

        Assertions.assertTrue(repository.getById(section.getId()).isEmpty());
    }

    @Test
    public void getAnimalById(){
        SectionCreator sectionCreator = new AfricanariumSectionCreator();

        Section section = sectionCreator.createSection();

        section.setUp(1L, "desc", true, 1.f, 1.f);

        repository.save(section);

        Optional<Section> sectionOptional = repository.getById(section.getId());

        Assertions.assertTrue(sectionOptional.isPresent());

        Assertions.assertEquals(section, sectionOptional.get());
    }
}
