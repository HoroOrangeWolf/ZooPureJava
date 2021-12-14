package Request;

import com.Michalski.Minner.Mozdzierz.Ozga.Request.Request;
import com.Michalski.Minner.Mozdzierz.Ozga.Request.RequestRepository;
import com.Michalski.Minner.Mozdzierz.Ozga.Request.Status;
import lombok.Setter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RequestRepositoryTest {

    @Setter
    private RequestRepository repository = new RequestRepository();

    @AfterEach
    public void remove(){
        repository.getByPredictor(f -> true).forEach(f -> repository.removeById(f.getId()));
        System.out.println("Wyczyszczono...");
    }

    @Test
    public void addRequest(){
        Request req = new Request(1L, Status.NIEROZPATRZONY, "Tekst testowy request");

        repository.save(req);
        Assertions.assertTrue(repository.getById(req.getId()).isPresent());
    }

    @Test
    public void updateRequest(){
        Request req = new Request(1L, Status.NIEROZPATRZONY, "Tekst testowy request nierozpatrzony");

        repository.save(req);

        Request req_update = new Request(1L, Status.ROZPATRZONY, "Tekst testowy request rozpatrzony update");
        req_update.setId(req.getId());
        repository.update(req_update);

        Assertions.assertEquals(req, req_update);
    }

    @Test
    public void removeRequest(){
        Request req = new Request(1L, Status.NIEROZPATRZONY, "Tekst testowy request nierozpatrzony");

        repository.save(req);

        Assertions.assertTrue(repository.getById(req.getId()).isPresent());

        repository.remove(req);

        Assertions.assertTrue(repository.getById(req.getId()).isEmpty());
    }

    @Test
    public void removeRequestById(){
        Request req = new Request(1L, Status.NIEROZPATRZONY, "Tekst testowy request nierozpatrzony");

        repository.save(req);

        Assertions.assertTrue(repository.getById(req.getId()).isPresent());

        repository.removeById(req.getId());

        Assertions.assertTrue(repository.getById(req.getId()).isEmpty());
    }

    @Test
    public void getRequestById(){
        Request req = new Request(1L, Status.NIEROZPATRZONY, "Tekst testowy request nierozpatrzony");

        repository.save(req);

        Assertions.assertTrue(repository.getById(req.getId()).isPresent());
    }
}
