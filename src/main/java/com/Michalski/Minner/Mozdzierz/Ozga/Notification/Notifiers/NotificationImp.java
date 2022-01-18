package com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers;

import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class NotificationImp implements Notification {

    private User user;

    @Override
    public void sendNotification() {

    }

    @Override
    public String getEmail() {
        return user.getEmail();
    }

    @Override
    public String getPhoneNumber() {
        return user.getPhoneNumber();
    }
}
