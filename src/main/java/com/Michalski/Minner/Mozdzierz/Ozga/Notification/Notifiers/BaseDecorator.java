package com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers;

import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BaseDecorator implements Notification {

    protected Notification notification;

    @Override
    public void sendNotification(String text) {

    }

    @Override
    public User getUser() {
        return notification.getUser();
    }

}
