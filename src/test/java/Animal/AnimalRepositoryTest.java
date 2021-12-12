package Animal;

import com.Michalski.Minner.Mozdzierz.Ozga.Animal.Animal;
import com.Michalski.Minner.Mozdzierz.Ozga.Animal.AnimalRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class AnimalRepositoryTest {

    private final AnimalRepository repository = new AnimalRepository();

    @AfterEach
    public void remove(){
        repository.getByPredictor(f -> true).forEach(f -> repository.removeById(f.getId()));
        System.out.println("Wyczyszczono...");
    }


    @Test
    public void addAnimal(){
        Animal animal1 = new Animal(1L, 1L, "Kot", "kot");

        repository.save(animal1);

        Assertions.assertTrue(repository.getById(animal1.getId()).isPresent());
    }

    @Test
    public void updateAnimal(){
        Animal animal1 = new Animal(1L, 1L, "Kot", "kot");

        repository.save(animal1);

        Animal animal2 = new Animal(animal1.getId(), 1L, "Do aktualizacij", "kot");

        repository.update(animal2);

        Assertions.assertEquals(animal1, animal2);
    }

    @Test
    public void removeAnimal(){
        Animal animal1 = new Animal(1L, 1L, "Kot", "kot");

        repository.save(animal1);

        repository.remove(animal1);

        Assertions.assertTrue(repository.getById(animal1.getId()).isEmpty());
    }

    @Test
    public void removeAnimalById(){
        Animal animal1 = new Animal(1L, 1L, "Kot", "kot");

        repository.save(animal1);

        repository.removeById(animal1.getId());

        Assertions.assertTrue(repository.getById(animal1.getId()).isEmpty());
    }

    @Test
    public void getAnimalById(){
        Animal animal1 = new Animal(1L, 1L, "Kot", "kot");

        repository.save(animal1);

        Optional<Animal> animal = repository.getById(animal1.getId());

        Assertions.assertTrue(animal.isPresent());

        Assertions.assertEquals(animal1, animal.get());
    }
}
