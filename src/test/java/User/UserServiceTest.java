package User;

import com.Michalski.Minner.Mozdzierz.Ozga.Animal.Section;
import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import com.Michalski.Minner.Mozdzierz.Ozga.User.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class UserServiceTest {
    private final UserService service = new UserService();

    @AfterEach
    public void remove(){
        System.out.println("Wyczyszczono...");
    }

    @Test
    public void addUser(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();
        User u1 = new User(1L,"siema",false, date,"user@test.com");
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
        User u1 = new User(1L,"siema",false, date,"user@test.com");


        Assertions.assertThrows(IllegalStateException.class, ()->{
            service.addUser(u1);
        });
    }

    @Test
    public void removeUser(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();
        User u1 = new User(1L,"siema",false, date,"user@test.com");
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
        User u1 = new User(1L,"siema",false, date,"user@test.com");
        service.addUser(u1);
        User u2 = new User(u1.getId(),"siemaaaaa",false, date,"user@test.com");
        service.updateUser(u2);
        Assertions.assertEquals(u2,u1);
    }
    @Test void isUserBok(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();
        User u1 = new User(1L,"siema",true, date,"user@test.com");
        service.addUser(u1);

        Assertions.assertTrue(service.isUserBok(u1.getId()));
    }
}
