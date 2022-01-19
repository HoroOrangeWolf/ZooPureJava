package com.Michalski.Minner.Mozdzierz.Ozga.Notification.Notifiers;

public class AppNotifierDecorator extends BaseDecorator{
    public AppNotifierDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void sendNotification(String text) {
        System.out.println("Wyslano notification na aplikacje: " + notification.getUser().getEmail());
        notification.sendNotification(text);
    }
}
