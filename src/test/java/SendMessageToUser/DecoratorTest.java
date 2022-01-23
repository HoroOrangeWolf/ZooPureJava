package SendMessageToUser;

import com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers.*;
import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DecoratorTest {

    @Test
    public void SMSDecoratorTest(){

        Date date = new Date();
        User u1 = new User("siema",false, date,"user@test.com");

        Subscriber subscriber = new SMSNotifierDecorator(u1);

        subscriber.sendMessage("Ta o jest wiadomość przez SMS");

        assertTrue(u1.getSMSNotificationReceived());
        assertFalse(u1.getAppNotificationReceived());
        assertFalse(u1.getWebNotificationReceived());
        assertFalse(u1.getAppNotificationReceived());
        assertFalse(u1.getEmailNotificationReceived());
    }

    @Test
    public void allDecoratorTests(){
        Date date = new Date();
        User u1 = new User("siema",false, date,"user@test.com");

        Subscriber subscriber = new SMSNotifierDecorator(u1);

        subscriber = new AppNotifierDecorator(subscriber);

        subscriber = new WebNotifierDecorator(subscriber);

        subscriber = new EmailNotifierDecorator(subscriber);


        subscriber.sendMessage("Ta o jest wiadomość przez SMS");

        assertTrue(u1.getSMSNotificationReceived());
        assertTrue(u1.getWebNotificationReceived());
        assertTrue(u1.getAppNotificationReceived());
        assertTrue(u1.getEmailNotificationReceived());
    }

}
