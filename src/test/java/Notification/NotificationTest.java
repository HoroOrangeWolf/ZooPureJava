package Notification;

import com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers.*;
import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class NotificationTest {

    @Test
    public void testowa(){
        NotificationImp imp = new NotificationImp(new User("pass", false, new Date(), "@gmail.com"));


        Notification notification = new SMSNotifierDecorator(imp);

        System.out.println("----------");
        notification.sendNotification("t");
        System.out.println("----------");
        notification = new WebNotifierDecorator(notification);
        notification.sendNotification("t");
        System.out.println("----------");
        notification = new EmailNotifierDecorator(notification);
        notification.sendNotification("t");
        System.out.println("----------");
        notification = new AppNotifierDecorator(notification);
        notification.sendNotification("t");
        System.out.println("----------");

    }

}
