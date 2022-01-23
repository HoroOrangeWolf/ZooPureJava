package SendMessageToUser;

import com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers.*;
import com.Michalski.Minner.Mozdzierz.Ozga.Observer.NewsletterNotifier;
import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewsletterNotifierTest {

    @Test
    public void addSubscriber(){
        Date date = new Date();

        NewsletterNotifier newsletterNotifier = new NewsletterNotifier();

        User u1 = new User("siema",false, date,"user@test.com");

        newsletterNotifier.addSubscriber(u1);


        assertTrue(newsletterNotifier.getSubscribers().contains(u1));
    }

    @Test
    public void removeSubscriber(){
        Date date = new Date();

        NewsletterNotifier newsletterNotifier = new NewsletterNotifier();

        User u1 = new User("siema",false, date,"user@test.com");

        u1.setId(15L);;

        newsletterNotifier.addSubscriber(u1);

        newsletterNotifier.removeSubscriber(15L);


        assertFalse(newsletterNotifier.getSubscribers().contains(u1));
    }


    @Test
    public void notifySubscribers(){
        //given
        NewsletterNotifier newsletterNotifier = new NewsletterNotifier();
        Date date = new Date();
        User u1 = new User("siema",false, date,"user@test.com");

        Subscriber subscriber1 = new SMSNotifierDecorator(u1);

        subscriber1 = new AppNotifierDecorator(subscriber1);

        subscriber1 = new WebNotifierDecorator(subscriber1);

        subscriber1 = new EmailNotifierDecorator(subscriber1);

        User u2 = new User("siema",false, date,"user@test.com");

        Subscriber subscriber2 = new SMSNotifierDecorator(u2);

        subscriber2 = new AppNotifierDecorator(subscriber2);


        //when
        newsletterNotifier.addSubscriber(subscriber1);
        newsletterNotifier.addSubscriber(subscriber2);
        newsletterNotifier.notifySubscribers("Wiadomosc dla każdego");

        //then

        assertTrue(u1.getSMSNotificationReceived());
        assertTrue(u1.getWebNotificationReceived());
        assertTrue(u1.getAppNotificationReceived());
        assertTrue(u1.getEmailNotificationReceived());

        assertTrue(u2.getAppNotificationReceived());
        assertTrue(u2.getSMSNotificationReceived());
    }

}
