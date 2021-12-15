package Ticket;

import com.Michalski.Minner.Mozdzierz.Ozga.Animal.Animal;
import com.Michalski.Minner.Mozdzierz.Ozga.Animal.AnimalRepository;
import com.Michalski.Minner.Mozdzierz.Ozga.Tickets.Advertisement;
import com.Michalski.Minner.Mozdzierz.Ozga.Tickets.AdvertisementRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

public class AdvertisementRepositoryTest {

    private final AdvertisementRepository repository = new AdvertisementRepository();

    @AfterEach
    public void remove(){
        repository.getByPredictor(f -> true).forEach(f -> repository.removeById(f.getId()));
        System.out.println("Wyczyszczono...");
    }


    @Test
    public void addAdvertisement(){
        Advertisement advertisement1 = new Advertisement(1L, 500.f, new ArrayList<>());

        repository.save(advertisement1);

        Assertions.assertTrue(repository.getById(advertisement1.getId()).isPresent());
    }

    @Test
    public void updateAdvertisement(){
        Advertisement advertisement1 = new Advertisement(1L, 500.f, new ArrayList<>());

        repository.save(advertisement1);

        Advertisement advertisement2 = new Advertisement(advertisement1.getId(), 450.f, new ArrayList<>());

        repository.update(advertisement2);

        Assertions.assertEquals(advertisement1, advertisement2);
    }

    @Test
    public void removeAdvertisement(){
        Advertisement advertisement1 = new Advertisement(1L, 120.f, new ArrayList<>());

        repository.save(advertisement1);

        repository.remove(advertisement1);

        Assertions.assertTrue(repository.getById(advertisement1.getId()).isEmpty());
    }

    @Test
    public void removeAdvertisementById(){
        Advertisement advertisement1 = new Advertisement(1L, 120.f, new ArrayList<>());

        repository.save(advertisement1);

        repository.removeById(advertisement1.getId());

        Assertions.assertTrue(repository.getById(advertisement1.getId()).isEmpty());
    }

    @Test
    public void getAdvertisementById(){
        Advertisement advertisement1 = new Advertisement(1L, 120.f, new ArrayList<>());

        repository.save(advertisement1);

        Optional<Advertisement> advertisement = repository.getById(advertisement1.getId());

        Assertions.assertTrue(advertisement.isPresent());

        Assertions.assertEquals(advertisement1, advertisement.get());
    }

}
