package Request;

import com.Michalski.Minner.Mozdzierz.Ozga.Request.Request;
import com.Michalski.Minner.Mozdzierz.Ozga.Request.RequestRepository;
import com.Michalski.Minner.Mozdzierz.Ozga.Request.RequestService;
import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import com.Michalski.Minner.Mozdzierz.Ozga.User.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static com.Michalski.Minner.Mozdzierz.Ozga.Request.Status.*;
import static org.junit.jupiter.api.Assertions.*;

public class RequestServiceTest {

    private final RequestRepository requestRepository = new RequestRepository();
    private final RequestService service = new RequestService();
    private final UserRepository userRepository = new UserRepository();

    @AfterEach
    void clear(){
        for(Request request : requestRepository.getByPredictor(f->true))
            requestRepository.removeById(request.getId());

        for(User user : userRepository.getByPredictor(f->true))
            requestRepository.removeById(user.getId());
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

        User user_bok = new User("czesc",true, date,"user2@test.com");

        Request request = new Request("Rozpatrywany ", u1);

        request.setStatus(ROZPATRYWANY);

        Request request1 = new Request("Rozpatrzony ", u1);

        request1.setStatus(ROZPATRZONY);

        Request request2 = new Request("Nierozpatrzony ", u1);

        request2.setStatus(NIEROZPATRZONY);

        requestRepository.save(request);
        requestRepository.save(request1);
        requestRepository.save(request2);

        Request nextToView = service.getNextToView(user_bok);

        assertNotNull(nextToView);

        assertEquals(nextToView, request);

        assertSame(nextToView.getStatus(), ROZPATRYWANY);

    }

    @Test
    void getNextToViewUserIsNotBok(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();

        User u1 = new User("siema",false, date,"user@test.com");

        userRepository.save(u1);

        User user_bok = new User("czesc",false, date,"user2@test.com");

        Request request = new Request("Rozpatrywany ", u1);

        request.setStatus(ROZPATRYWANY);

        Request request1 = new Request("Rozpatrzony ", u1);

        request1.setStatus(ROZPATRZONY);

        Request request2 = new Request("Nierozpatrzony ", u1);

        request2.setStatus(NIEROZPATRZONY);

        requestRepository.save(request);
        requestRepository.save(request1);
        requestRepository.save(request2);

        assertThrows(IllegalStateException.class, ()->{
            Request nextToView = service.getNextToView(user_bok);
        }, "User is not bok!" );




    }

    @Test
    void getNextToViewWithNoMoreRequests(){

        User user_bok = new User("czesc",true, new Date(),"user2@test.com");

        Request nextToView = service.getNextToView(user_bok);

        assertNull(nextToView);
    }

    @Test
    void updateRequestsNoBokUser(){

        User user_bok = new User("czesc",true, new Date(),"user2@test.com");

        Request nextToView = service.getNextToView(user_bok);

        assertNull(nextToView);
    }



    @Test
    void updateRequest(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();

        User u1 = new User("siema",false, date,"user@test.com");

        userRepository.save(u1);

        Request request = new Request("Add Request", u1);

        service.addRequest(request);

        User user_bok = new User("czesc",true, new Date(),"user2@test.com");

        userRepository.save(user_bok);

        request.setBokUser(user_bok);

        Request toUpdated = new Request("New Request", u1);

        toUpdated.setBokUser(user_bok);

        toUpdated.setId(request.getId());

        service.updateRequest(toUpdated, user_bok);

        assertEquals(toUpdated, request);
    }

    @Test
    void updateRequestNoBokUser(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();

        User u1 = new User("siema",false, date,"user@test.com");

        Request request = new Request("Add Request", u1);

        service.addRequest(request);

        User user_bok = new User("czesc",true, new Date(),"user2@test.com");

        Request toUpdated = new Request("New Request", u1);

        toUpdated.setId(request.getId());

        assertThrows(IllegalStateException.class, ()->{
            service.updateRequest(toUpdated, user_bok);
        }, "User is not bok!");
    }

    @Test
    void updateRequestNotSameBokUser(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();

        User u1 = new User("siema",false, date,"user@test.com");

        User u2 = new User("bok",true, date,"bok@test.com");

        User other = new User("other_bok",true, date,"Otherbok@test.com");

        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(other);

        Request request = new Request("Add Request", u1);

        service.addRequest(request);

        service.getNextToView(u2);


        assertThrows(IllegalStateException.class, ()->{
            service.updateRequest(request, other);
        }, "Current request is being operate by other BokUser");
    }



}
