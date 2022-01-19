package com.Michalski.Minner.Mozdzierz.Ozga.Observer;

import com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers.*;
import com.Michalski.Minner.Mozdzierz.Ozga.User.User;

public class SubscriberImp implements Subscriber{

    private final User user;

    public SubscriberImp(User user) {
        this.user = user;
    }

    @Override
    public void notifySubscriber(String informationText) {
            Notification notification = new NotificationImp(user);

            if(user.getIsAppNotification())
                notification = new AppNotifierDecorator(notification);

            if(user.getIsEmailNotification())
                notification = new EmailNotifierDecorator(notification);

            if(user.getIsSMSNotification())
                notification = new SMSNotifierDecorator(notification);

            if(user.getIsWebNotification())
                notification = new WebNotifierDecorator(notification);

            notification.sendNotification(informationText);
    }

    @Override
    public long getSubscriberId() {
        return user.getId();
    }
}
