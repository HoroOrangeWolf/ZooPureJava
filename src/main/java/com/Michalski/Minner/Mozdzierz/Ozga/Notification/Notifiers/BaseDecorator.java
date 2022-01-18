package com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BaseDecorator implements Notification {

    protected Notification notification;

    @Override
    public void sendNotification() {

    }

    @Override
    public String getEmail() {
        return notification.getEmail();
    }

    @Override
    public String getPhoneNumber() {
        return notification.getPhoneNumber();
    }
}
