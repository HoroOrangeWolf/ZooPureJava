package Request;

import com.Michalski.Minner.Mozdzierz.Ozga.Request.Request;
import com.Michalski.Minner.Mozdzierz.Ozga.Request.RequestRepository;
import com.Michalski.Minner.Mozdzierz.Ozga.Request.Status;
import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import lombok.Setter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

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
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();

        User u1 = new User("siema",false, date,"user@test.com");
        Request req = new Request("Tekst testowy request", u1);

        repository.save(req);
        Assertions.assertTrue(repository.getById(req.getId()).isPresent());
    }

    @Test
    public void updateRequest(){

        User u1 = new User("siema",false, new Date(),"user@test.com");

        Request req = new Request("Tekst testowy request nierozpatrzony", u1);

        repository.save(req);

        Request req_update = new Request( "Tekst testowy request rozpatrzony update", u1);

        req_update.setStatus(Status.ROZPATRZONY);

        req_update.setId(req.getId());
        repository.update(req_update);

        Assertions.assertEquals(req, req_update);
    }

    @Test
    public void removeRequest(){
        User u1 = new User("siema",false, new Date(),"user@test.com");

        Request req = new Request("Tekst testowy request nierozpatrzony", u1);

        repository.save(req);

        Assertions.assertTrue(repository.getById(req.getId()).isPresent());

        repository.remove(req);

        Assertions.assertTrue(repository.getById(req.getId()).isEmpty());
    }

    @Test
    public void removeRequestById(){
        User u1 = new User("siema",false, new Date(),"user@test.com");

        Request req = new Request("Tekst testowy request nierozpatrzony", u1);

        repository.save(req);

        Assertions.assertTrue(repository.getById(req.getId()).isPresent());

        repository.removeById(req.getId());

        Assertions.assertTrue(repository.getById(req.getId()).isEmpty());
    }

    @Test
    public void getRequestById(){
        User u1 = new User("siema",false, new Date(),"user@test.com");

        Request req = new Request("Tekst testowy request nierozpatrzony", u1);

        repository.save(req);

        Assertions.assertTrue(repository.getById(req.getId()).isPresent());
    }
}
