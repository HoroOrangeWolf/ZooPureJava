package Request;

import com.Michalski.Minner.Mozdzierz.Ozga.Request.Request;
import com.Michalski.Minner.Mozdzierz.Ozga.Request.RequestRepository;
import com.Michalski.Minner.Mozdzierz.Ozga.Request.RequestService;
import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static com.Michalski.Minner.Mozdzierz.Ozga.Request.Status.*;
import static org.junit.jupiter.api.Assertions.*;

public class RequestServiceTest {

    private final RequestRepository requestRepository = new RequestRepository();
    private final RequestService service = new RequestService();

    @AfterEach
    void clear(){
        for(Request request : requestRepository.getByPredictor(f->true))
            requestRepository.removeById(request.getId());

    }

    @Test
    void addRequest(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();

        User u1 = new User("siema",false, date,"user@test.com");

        Request request = new Request("Add Request", u1);

        service.addRequest(request);

        assertTrue(requestRepository.getById(request.getId()).isPresent());
    }

    //Podaje następny wniosek do rozpatrzenia i zmienia jego stan na rozpatrywany
    @Test
    void getNextToView(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();

        User u1 = new User("siema",false, date,"user@test.com");

        Request request = new Request("Rozpatrywany ", u1);

        request.setStatus(ROZPATRYWANY);

        Request request1 = new Request("Rozpatrzony ", u1);

        request1.setStatus(ROZPATRZONY);

        Request request2 = new Request("Nierozpatrzony ", u1);

        request2.setStatus(NIEROZPATRZONY);

        requestRepository.save(request);
        requestRepository.save(request1);
        requestRepository.save(request2);

        Request nextToView = service.getNextToView();

        assertNotNull(nextToView);

        assertEquals(nextToView, request);

        assertSame(nextToView.getStatus(), ROZPATRYWANY);

    }

    @Test
    void updateRequest(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();

        User u1 = new User("siema",false, date,"user@test.com");

        Request request = new Request("Add Request", u1);

        service.addRequest(request);


        Request toUpdated = new Request("New Request", u1);

        toUpdated.setId(request.getId());

        service.updateRequest(toUpdated);

        assertEquals(toUpdated, request);
    }




}
