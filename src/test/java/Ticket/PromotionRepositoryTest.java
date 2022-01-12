package Ticket;

import com.Michalski.Minner.Mozdzierz.Ozga.Tickets.Promotion;
import com.Michalski.Minner.Mozdzierz.Ozga.Tickets.PromotionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

public class PromotionRepositoryTest {

    private final PromotionRepository repository = new PromotionRepository();

    @AfterEach
    public void remove(){
        repository.getByPredictor(f -> true).forEach(f -> repository.removeById(f.getId()));
        System.out.println("Wyczyszczono...");
    }


    @Test
    public void addAdvertisement(){
        Promotion promotion1 = new Promotion(1L, new BigDecimal("255."), new ArrayList<>());

        repository.save(promotion1);

        Assertions.assertTrue(repository.getById(promotion1.getId()).isPresent());
    }

    @Test
    public void updateAdvertisement(){
        Promotion promotion1 = new Promotion(1L, new BigDecimal("500."), new ArrayList<>());

        repository.save(promotion1);

        Promotion promotion2 = new Promotion(promotion1.getId(), new BigDecimal("450."), new ArrayList<>());

        repository.update(promotion2);

        Assertions.assertEquals(promotion1, promotion2);
    }

    @Test
    public void removeAdvertisement(){
        Promotion promotion1 = new Promotion(1L, new BigDecimal("120."), new ArrayList<>());

        repository.save(promotion1);

        repository.remove(promotion1);

        Assertions.assertTrue(repository.getById(promotion1.getId()).isEmpty());
    }

    @Test
    public void removeAdvertisementById(){
        Promotion promotion1 = new Promotion(1L, new BigDecimal("120."), new ArrayList<>());

        repository.save(promotion1);

        repository.removeById(promotion1.getId());

        Assertions.assertTrue(repository.getById(promotion1.getId()).isEmpty());
    }

    @Test
    public void getAdvertisementById(){
        Promotion promotion1 = new Promotion(1L, new BigDecimal("120."), new ArrayList<>());

        repository.save(promotion1);

        Optional<Promotion> advertisement = repository.getById(promotion1.getId());

        Assertions.assertTrue(advertisement.isPresent());

        Assertions.assertEquals(promotion1, advertisement.get());
    }

}
