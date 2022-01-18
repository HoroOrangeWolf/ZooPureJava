package User;

import com.Michalski.Minner.Mozdzierz.Ozga.Animal.Section;
import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import com.Michalski.Minner.Mozdzierz.Ozga.User.UserRepository;
import com.Michalski.Minner.Mozdzierz.Ozga.User.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class UserServiceTest {
    private final UserService service = new UserService();
    private final UserRepository repository = new UserRepository();

    @AfterEach
    public void remove(){
        System.out.println("Wyczyszczono...");

        repository.getByPredictor(f -> true).forEach(f -> repository.removeById(f.getId()));
    }

    @Test
    public void addUser(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();
        User u1 = new User("siema",false, date,"user@test.com");
        service.addUser(u1);

        Optional<User> user = service.getUserByEmail(u1.getEmail());

        Assertions.assertTrue(user.isPresent());
        Assertions.assertEquals(u1,user.get());
    }

    @Test
    public void addUserIfEmailIsTake(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();
        User u1 = new User("siema",false, date,"user@test.com");
        User u2 = new User("Ryszard",false, date,"user@test.com");

        service.addUser(u1);


        Assertions.assertThrows(IllegalStateException.class, ()->{
            service.addUser(u2);
        });
    }

    @Test
    public void removeUser(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();
        User u1 = new User("siema",false, date,"user@test.com");
        service.addUser(u1);

        Optional<User> user = service.getUserByEmail(u1.getEmail());

        Assertions.assertTrue(user.isPresent());

        Assertions.assertEquals(u1,user.get());

        service.removeUser(u1.getId());

        Assertions.assertTrue(service.getUserByEmail(u1.getEmail()).isEmpty());
    }
    @Test void updateUser(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();
        User u1 = new User("siema",false, date,"user@test.com");
        service.addUser(u1);
        User u2 = new User("siemaaaaa",false, date,"user@test.com");

        u2.setId(u1.getId());

        service.updateUser(u2);
        Assertions.assertEquals(u2,u1);
    }
    @Test void isUserBok(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();
        User u1 = new User("siema",true, date,"user@test.com");
        service.addUser(u1);

        Assertions.assertTrue(service.isUserBok(u1.getId()));
    }
}
