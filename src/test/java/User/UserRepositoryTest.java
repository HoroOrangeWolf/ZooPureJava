package User;

import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import com.Michalski.Minner.Mozdzierz.Ozga.User.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class UserRepositoryTest {
    private final UserRepository repository = new UserRepository();
    @AfterEach
    public void remove(){
        repository.getByPredictor(f->true).forEach((f->repository.removeById(f.getId())));
        System.out.println("Wyczyszczono...");
    }
    @Test
    public void addUser(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();
        User u1 = new User(1L,"siema",false, date,"user@test.com");
        repository.save(u1);
        Assertions.assertTrue(repository.getById(u1.getId()).isPresent());
    }
    @Test
    public void updateUser(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();

        User u1 = new User(1L,"siema",false, date,"user@test.com");

        repository.save(u1);

        User u2 = new User(u1.getId(),"zmiana hasla",true, date,"user@test.com");

        repository.update(u2);

        Assertions.assertEquals(u1,u2);
    }
    @Test
    public void removeUser(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();

        User u1 = new User(1L,"siema",false, date,"user@test.com");

        repository.save(u1);

        repository.remove(u1);

        Assertions.assertTrue(repository.getById(u1.getId()).isEmpty());

    }
    @Test
    public void removeUserBtId(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();

        User u1 = new User(1L,"siema",false, date,"user@test.com");

        repository.save(u1);

        repository.removeById(u1.getId());

        Assertions.assertTrue(repository.getById(u1.getId()).isEmpty());
    }
    @Test
    public void getUserById(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();

        User u1 = new User(1L,"siema",false, date,"user@test.com");

        repository.save(u1);

        Optional<User> user = repository.getById(u1.getId());

        Assertions.assertTrue(user.isPresent());

        Assertions.assertEquals(u1,user.get());
    }
    @Test
    public void getUserByEmail(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();

        User u1 = new User(1L,"siema",false, date,"user@test.com");

        repository.save(u1);

        Optional<User> user = repository.getUserByEmail(u1.getEmail());

        Assertions.assertTrue(user.isPresent());

        Assertions.assertEquals(u1,user.get());
    }
    @Test
    public void userIsEmailTaken(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();

        User u1 = new User(1L,"siema",false, date,"user@test.com");

        repository.save(u1);

        User u2 = new User(2L,"siema",false, date,"user@test.com");

        repository.save(u2);

        Assertions.assertTrue(repository.isEmailTaken(u2.getEmail()));

    }
    @Test
    public void userIsBokUser(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date date = cal.getTime();

        User u1 = new User(1L,"siema",true, date,"user@test.com");

        repository.save(u1);

        Assertions.assertTrue(repository.isBokUser(u1.getId()));
    }
}
