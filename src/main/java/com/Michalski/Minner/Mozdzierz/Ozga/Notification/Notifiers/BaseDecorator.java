package com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers;

import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BaseDecorator implements Subscriber {

    private final Subscriber sender;


    @Override
    public void sendMessage(String text) {

    }

    @Override
    public User getUser() {
        return (User) sender;
    }
}
