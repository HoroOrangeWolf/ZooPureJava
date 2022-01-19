package com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers;

import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class NotificationImp implements Notification {

    private User user;

    @Override
    public void sendNotification(String text) {

    }

    @Override
    public User getUser() {
        return user;
    }

}
